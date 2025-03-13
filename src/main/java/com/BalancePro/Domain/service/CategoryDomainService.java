package com.BalancePro.Domain.service;

import com.BalancePro.Domain.entity.Category;
import com.BalancePro.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class CategoryDomainService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryDomainService(CategoryRepository categoryRepository){
        repository = categoryRepository;
    }

    public List<Category> getAll(){
        return repository.findAll();
    }

    public Category getById(UUID id){
        return repository.getReferenceById(id);
    }
}
