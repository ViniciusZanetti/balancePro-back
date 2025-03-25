package com.BalancePro.Domain.mapper;

import com.BalancePro.Domain.DTO.category.CategoryCreateDTO;
import com.BalancePro.Domain.DTO.category.CategoryResponseDTO;
import com.BalancePro.Domain.DTO.category.CategoryUpdateDTO;
import com.BalancePro.Domain.DTO.users.UserCreateDTO;
import com.BalancePro.Domain.entity.Category;
import com.BalancePro.Domain.entity.User;
import com.BalancePro.Repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryCreateDTO createDTO) {
        return Category.builder()
                .name(createDTO.getName())
                .description(createDTO.getDescription())
                .build();
    }

    public void updateEntityFromDto(CategoryUpdateDTO updateDTO, Category category) {
        if (updateDTO.getName() != null) {
            category.setName(updateDTO.getName());
        }
        if (updateDTO.getDescription() != null) {
            category.setDescription(updateDTO.getDescription());
        }
    }

    public CategoryResponseDTO toResponseDTO(Category category) {
        return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
