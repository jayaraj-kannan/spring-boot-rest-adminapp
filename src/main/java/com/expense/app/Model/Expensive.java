package com.expense.app.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="EXPENSIVE")
public class Expensive {
    @SequenceGenerator(
            name = "expenses_sequence",
            sequenceName = "expenses_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "expenses_sequence"
    )
    private Long id;
    @Column(name = "EXPENSIVE_SOURCE")
    @Enumerated(EnumType.STRING)
    private ExpensiveSource expensiveSource;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    @Column(name = "EXPENSIVE_DES")
    private String description;
    @Column(name = "EXPENSIVE_AMOUNT")
    private String amount;
    @Column(name="EXPENSIVE_CATEGORY")
    @Enumerated(EnumType.STRING)
    private ExpensiveCategory expensiveCategory;

    @Column(name="EXPENSIVE_TYPE")
    @Enumerated(EnumType.STRING)
    private ExpensiveType expensiveType;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Expensive() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExpensiveSource getExpensiveSource() {
        return expensiveSource;
    }

    public void setExpensiveSource(ExpensiveSource expensiveSource) {
        this.expensiveSource = expensiveSource;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public ExpensiveCategory getExpensiveCategory() {
        return expensiveCategory;
    }

    public void setExpensiveCategory(ExpensiveCategory expensiveCategory) {
        this.expensiveCategory = expensiveCategory;
    }

    public ExpensiveType getExpensiveType() {
        return expensiveType;
    }

    public void setExpensiveType(ExpensiveType expensiveType) {
        this.expensiveType = expensiveType;
    }
}
