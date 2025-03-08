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
@Table(name = "closing")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Closing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private LocalDate closingDate;

    @Column
    private BigDecimal finalBalance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;
}
