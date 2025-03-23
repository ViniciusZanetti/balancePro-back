package com.BalancePro.Domain.mapper;

import com.BalancePro.Domain.DTO.users.UserCreateDTO;
import com.BalancePro.Domain.DTO.users.UserResponseDTO;
import com.BalancePro.Domain.DTO.users.UserUpdateDTO;
import com.BalancePro.Domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserCreateDTO createDTO) {
        return User.builder()
                .name(createDTO.getName())
                .email(createDTO.getEmail())
                .password(createDTO.getPassword())
                .build();
    }

    public void updateEntityFromDto(UserUpdateDTO updateDTO, User user) {
        if (updateDTO.getName() != null) {
            user.setName(updateDTO.getName());
        }
        if (updateDTO.getEmail() != null) {
            user.setEmail(updateDTO.getEmail());
        }
        if (updateDTO.getPassword() != null) {
            user.setPassword(updateDTO.getPassword());
        }
    }

    public UserResponseDTO toResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
