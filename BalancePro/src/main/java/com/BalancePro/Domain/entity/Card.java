package com.BalancePro.Domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String cardNumber;

    @Column
    private String nameHolder;

    @Column
    private String flag;

    @Column
    private BigDecimal creditLimit;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;
}
