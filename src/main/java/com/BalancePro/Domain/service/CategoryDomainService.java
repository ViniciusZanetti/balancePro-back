package com.BalancePro.Domain.service;

import com.BalancePro.Domain.DTO.CategoryDTO.CategoryReqDTO;
import com.BalancePro.Domain.DTO.CategoryDTO.CategoryResDTO;
import com.BalancePro.Domain.entity.Category;
import com.BalancePro.Domain.entity.User;
import com.BalancePro.Repository.CategoryRepository;
import com.BalancePro.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class CategoryDomainService {

    private final CategoryRepository repository;
    private final UserRepository repositoryUser;

    public CategoryDomainService(CategoryRepository categoryRepository, UserRepository userRepository){
        repository = categoryRepository;
        repositoryUser = userRepository;
    }

    public List<CategoryResDTO> getAll(){
        List<Category> categories = repository.findAll();

        return categories.stream().map(category -> new CategoryResDTO(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getUser()
        )).toList();
    }

    public Category getById(UUID id){
        return repository.getReferenceById(id);
    }

    public void create (CategoryReqDTO body){

        User user = repositoryUser.findById(body.userId()).orElseThrow(() -> new RuntimeException("User not found."));

        Category category = new Category();

        category.setName(body.name());
        category.setDescription(body.description());
        category.setUser(user);

        repository.save(category);
    }
}
