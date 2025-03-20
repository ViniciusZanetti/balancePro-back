package com.BalancePro.Domain.DTO.CategoryDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CategoryReqDTO(
        @NotBlank(message = "The field 'name' is required.")
        @NotNull(message = "The field 'name' cannot be null.")
        @Size(min = 3, max = 50, message = "The field 'name' must be between 3 and 50 characters long.")
        String name,

        @NotBlank(message = "The field 'description is required.'")
        @NotNull(message = "The field 'description' cannot be null.")
        @Size(min = 5, max = 255, message = "The field 'name' must be between 5 and 255 characters long.")
        String description,

        @NotBlank(message = "The field 'userId' is required.")
        @NotNull(message= "The field 'userId' cannot be null.")
        UUID userId
) {}
