package com.BalancePro.Domain.service;

import com.BalancePro.Domain.DTO.category.CategoryCreateDTO;
import com.BalancePro.Domain.DTO.category.CategoryResponseDTO;
import com.BalancePro.Domain.DTO.category.CategoryUpdateDTO;
import com.BalancePro.Domain.DTO.users.UserCreateDTO;
import com.BalancePro.Domain.DTO.users.UserResponseDTO;
import com.BalancePro.Domain.DTO.users.UserUpdateDTO;
import com.BalancePro.Domain.entity.Category;
import com.BalancePro.Domain.entity.User;
import com.BalancePro.Domain.exceptions.ResourceAlreadyExistsException;
import com.BalancePro.Domain.exceptions.ResourceNotFoundException;
import com.BalancePro.Domain.mapper.CategoryMapper;
import com.BalancePro.Domain.mapper.UserMapper;
import com.BalancePro.Repository.CategoryRepository;
import com.BalancePro.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryDomainService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;
    private final UserRepository userRepositoryService;

    public CategoryDomainService(CategoryRepository categoryRepository, CategoryMapper categoryMapper, UserRepository userRepository){
        repository = categoryRepository;
        mapper = categoryMapper;
        userRepositoryService = userRepository;
    }

    public List<CategoryResponseDTO> getAll(){
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CategoryResponseDTO getById(UUID id){
        return mapper.toResponseDTO(repository.getReferenceById(id));
    }

    @Transactional
    public CategoryResponseDTO createCategory(CategoryCreateDTO createDTO) {
        if (repository.findByName(createDTO.getName()).isPresent()) {
            throw new ResourceAlreadyExistsException("Categoria já existe: " + createDTO.getName());
        }

        User user = userRepositoryService.getReferenceById(createDTO.getUserId());

        Category category = mapper.toEntity(createDTO);
        category.setUser(user);
        Category savedCategory = repository.save(category);
        return mapper.toResponseDTO(savedCategory);
    }

    @Transactional
    public CategoryResponseDTO updateCategory(UUID id, CategoryUpdateDTO updateDTO) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrado com ID: " + id));

        if (updateDTO.getName() != null && !updateDTO.getName().equals(category.getName()) &&
               repository.findByName(updateDTO.getName()).isPresent()) {
            throw new ResourceAlreadyExistsException("Categoria já existente: " + updateDTO.getName());
        }

        mapper.updateEntityFromDto(updateDTO, category);
        Category updatedCategory = repository.save(category);
        return mapper.toResponseDTO(updatedCategory);
    }

    @Transactional
    public void deleteCategory(UUID id) {
        if (repository.existsById(id)) {
            throw new ResourceNotFoundException("Categoria não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
}
