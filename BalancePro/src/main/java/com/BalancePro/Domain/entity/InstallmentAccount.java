package com.BalancePro.Domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "installmentAccount")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InstallmentAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private BigDecimal totalValue;

    @Column
    private Integer remainingPearls;

    @Column
    private LocalDate expirationDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
