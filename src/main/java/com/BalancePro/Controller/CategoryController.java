package com.BalancePro.Controller;

import com.BalancePro.Application.service.CategoryApplicationService;
import com.BalancePro.Domain.DTO.CategoryDTO.CategoryResDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/category")
public class CategoryController {

    private final CategoryApplicationService categoryService;

    public CategoryController(CategoryApplicationService categoryApplicationService){
        categoryService = categoryApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResDTO>> getAll(){
        List<CategoryResDTO> categories = categoryService.getAll();

        return ResponseEntity.ok(categories);
    }
}
