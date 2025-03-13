package com.BalancePro.Repository;

import com.BalancePro.Domain.entity.InstallmentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstallmentAccountRepository extends JpaRepository<InstallmentAccount, UUID> {
}
