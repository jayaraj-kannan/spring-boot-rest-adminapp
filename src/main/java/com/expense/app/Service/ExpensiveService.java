package com.expense.app.Service;

import com.expense.app.Data.ExpensiveRepository;
import com.expense.app.Model.Expensive;
import com.expense.app.Data.ExpensiveRepository;
import com.expense.app.Model.Expensive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExpensiveService {
    @Autowired
    private final ExpensiveRepository expensiveRepository;

    public ExpensiveService(ExpensiveRepository expensiveRepository) {
        this.expensiveRepository = expensiveRepository;
    }
    public List<Expensive> getAllExpenses(){
       return expensiveRepository.findAll();
    }
    public String createExpense(Expensive expensive){
        try {
            expensiveRepository.save(expensive);
            return "Success";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    public List<Expensive> findByUser(Long id){
        return expensiveRepository.findByUserId(id);
    }

    @Transactional
    public String deleteById(Long id,Expensive expense){
        try {
            expensiveRepository.deleteById(id);
            return "success";
            // delete operation was successful
        } catch (EmptyResultDataAccessException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        }

    }
    public List<Expensive> findByYear(Long id,int year){
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return expensiveRepository.findByUserIdAndDateBetweenOrderByDateDesc(id,start, end);
    }
    public List<Integer> findDistinctYears(Long id){
        return expensiveRepository.findDistinctYearByUserId(id);
    }
    public BigDecimal getTotalByYear(Long id ,int year){
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return expensiveRepository.findTotalExpenseByUserIdAndDateBetween(id,start,end);
    }
    public BigDecimal getTotalByAll(Long id){
        return expensiveRepository.findTotalExpenseByUserId(id);
    }
    public List<Expensive> findBySource(Long id,String source){
        return expensiveRepository.findByUserIdAndExpensiveSource(id,source);
    }

}
