package com.expense.app.Data;

import com.expense.app.Model.MainBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BalanceRepository extends JpaRepository<MainBalance,Long> {
    Optional<MainBalance> findByUserId (Long Id);
}
