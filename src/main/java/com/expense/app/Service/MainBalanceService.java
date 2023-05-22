package com.expense.app.Service;

import com.expense.app.Data.BalanceRepository;
import com.expense.app.Model.MainBalance;
import com.expense.app.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MainBalanceService {
    @Autowired
    private final BalanceRepository balanceRepository;

    public MainBalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }
    public MainBalance getCurrentBalance(Long userId, User user){
        Optional<MainBalance> balanceOptional = balanceRepository.findByUserId(userId);
        if (balanceOptional.isPresent()) {
            return balanceOptional.get();
        } else {
            MainBalance newBalance = new MainBalance();
            newBalance.setUser(user);
            newBalance.setCreatedAt(LocalDateTime.now());
            newBalance.setUpdatedAt(LocalDateTime.now());
            return balanceRepository.save(newBalance);
        }

    }
    public BigDecimal updateBalance(MainBalance balance){
        return balanceRepository.save(balance).getTotal();
    }
}
