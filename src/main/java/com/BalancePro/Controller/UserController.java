package com.BalancePro.Controller;

import com.BalancePro.Domain.dto.users.UserCreateDTO;
import com.BalancePro.Domain.dto.users.UserResponseDTO;
import com.BalancePro.Domain.dto.users.UserUpdateDTO;
import com.BalancePro.Domain.service.UserDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserDomainService userDomainService;

    public UserController(UserDomainService userDomainServiceService) {
        this.userDomainService = userDomainServiceService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Validated @RequestBody UserCreateDTO createDTO) {
        UserResponseDTO createdUser = userDomainService.createUser(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userDomainService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userDomainService.getUserById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userDomainService.getUserByEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable UUID id,
            @Validated @RequestBody UserUpdateDTO updateDTO) {
        return ResponseEntity.ok(userDomainService.updateUser(id, updateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userDomainService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
