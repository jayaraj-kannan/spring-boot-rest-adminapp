package com.expense.app.Data;

import com.expense.app.Model.Expensive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ExpensiveRepository extends JpaRepository<Expensive,String> {

    List<Expensive> findByUserId(Long id);
    void deleteById(Long id);

    List<Expensive> findByUserIdAndDateBetweenOrderByDateDesc(Long id,LocalDate start, LocalDate end);
    @Query(value="SELECT DISTINCT DATE_PART('year', CAST(e.date AS DATE)) AS years " +
            "FROM Expensive e WHERE e.user_id = :userId AND e.date IS NOT NULL ORDER BY years DESC", nativeQuery = true)
    List<Integer> findDistinctYearByUserId(Long userId);

    List<Expensive> findByUserIdAndExpensiveSource(Long id,String source);
    @Query(value="select sum(CAST(e.expensive_amount AS numeric)) " +
            "from Expensive e where e.user_id = :userId AND e.date between :startDate and :endDate ",nativeQuery = true)
    BigDecimal findTotalExpenseByUserIdAndDateBetween(Long userId,LocalDate startDate,LocalDate endDate);

    @Query(value="select sum(CAST(e.expensive_amount AS numeric)) " +
            "from Expensive e where e.user_id = :userId ",nativeQuery = true)
    BigDecimal findTotalExpenseByUserId(Long userId);
}
