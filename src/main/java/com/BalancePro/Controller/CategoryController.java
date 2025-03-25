package com.BalancePro.Controller;

import com.BalancePro.Domain.DTO.category.CategoryCreateDTO;
import com.BalancePro.Domain.DTO.category.CategoryResponseDTO;
import com.BalancePro.Domain.DTO.category.CategoryUpdateDTO;
import com.BalancePro.Domain.service.CategoryDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryDomainService service;

    public CategoryController(CategoryDomainService categoryDomainService) {
        this.service = categoryDomainService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@Validated @RequestBody CategoryCreateDTO createDTO) {
        CategoryResponseDTO createdCategory = service.createCategory(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update(
            @PathVariable UUID id,
            @Validated @RequestBody CategoryUpdateDTO updateDTO) {
        return ResponseEntity.ok(service.updateCategory(id, updateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
