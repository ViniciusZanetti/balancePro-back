package com.BalancePro.Repository;

import com.BalancePro.Domain.entity.Closing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClosingRepository extends JpaRepository<Closing, UUID> {
}
