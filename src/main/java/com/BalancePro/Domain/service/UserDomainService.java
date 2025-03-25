package com.BalancePro.Domain.service;

import com.BalancePro.Domain.DTO.users.UserCreateDTO;
import com.BalancePro.Domain.DTO.users.UserResponseDTO;
import com.BalancePro.Domain.DTO.users.UserUpdateDTO;
import com.BalancePro.Domain.entity.User;
import com.BalancePro.Domain.exceptions.ResourceAlreadyExistsException;
import com.BalancePro.Domain.exceptions.ResourceNotFoundException;
import com.BalancePro.Domain.mapper.UserMapper;
import com.BalancePro.Repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserDomainService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDomainService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserResponseDTO createUser(UserCreateDTO createDTO) {
        if (userRepository.findByEmail(createDTO.getEmail()).isPresent()) {
            throw new ResourceAlreadyExistsException("Email já está em uso: " + createDTO.getEmail());
        }

        User user = userMapper.toEntity(createDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDTO(savedUser);
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
        return userMapper.toResponseDTO(user);
    }

    public UserResponseDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com email: " + email));
        return userMapper.toResponseDTO(user);
    }

    @Transactional
    public UserResponseDTO updateUser(UUID id, UserUpdateDTO updateDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));

        if (updateDTO.getEmail() != null && !updateDTO.getEmail().equals(user.getEmail()) &&
                userRepository.findByEmail(updateDTO.getEmail()).isPresent()) {
            throw new ResourceAlreadyExistsException("Email já está em uso: " + updateDTO.getEmail());
        }

        userMapper.updateEntityFromDto(updateDTO, user);
        User updatedUser = userRepository.save(user);
        return userMapper.toResponseDTO(updatedUser);
    }

    @Transactional
    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado com ID: " + id);
        }
        userRepository.deleteById(id);
    }
}