package com.BalancePro.Domain.DTO.category;

import com.BalancePro.Domain.DTO.users.UserResponseDTO;
import com.BalancePro.Domain.entity.User;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDTO {
    private UUID id;
    private String name;
    private String description;
    private UserResponseDTO user;
}
