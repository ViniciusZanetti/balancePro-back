package com.BalancePro.Domain.dto.users;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {
    private String name;
    private String email;
    private String password;
}
