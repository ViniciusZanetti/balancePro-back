package com.BalancePro.Domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;

    @Column
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
