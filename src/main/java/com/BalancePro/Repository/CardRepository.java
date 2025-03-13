package com.BalancePro.Repository;

import com.BalancePro.Domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
}
