package com.BalancePro.Domain.DTO.category;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateDTO {
    private String name;
    private String description;
}
