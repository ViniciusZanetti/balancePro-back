package com.BalancePro.Domain.DTO.category;

import com.BalancePro.Domain.DTO.users.UserCreateDTO;
import com.BalancePro.Domain.entity.User;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateDTO {
    private String name;
    private String description;
    private UUID userId;
}
