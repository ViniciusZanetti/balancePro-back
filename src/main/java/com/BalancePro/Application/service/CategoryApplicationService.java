package com.BalancePro.Application.service;

import com.BalancePro.Domain.DTO.CategoryDTO.CategoryResDTO;
import com.BalancePro.Domain.service.CategoryDomainService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryApplicationService {

    private final CategoryDomainService categoryService;

    public CategoryApplicationService(CategoryDomainService categoryDomainService){
        categoryService = categoryDomainService;
    }

    public List<CategoryResDTO> getAll(){
        return categoryService.getAll();
    }
}
