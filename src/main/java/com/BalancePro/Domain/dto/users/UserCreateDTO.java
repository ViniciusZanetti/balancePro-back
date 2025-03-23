package com.BalancePro.Domain.DTO.users;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {
    private String name;
    private String email;
    private String password;
}
