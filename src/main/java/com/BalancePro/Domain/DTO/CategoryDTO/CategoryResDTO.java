package com.BalancePro.Domain.DTO.CategoryDTO;

import com.BalancePro.Domain.entity.User;

import java.util.UUID;

public record CategoryResDTO(
    UUID id,
    String name,
    String description,
    User user
) {}
