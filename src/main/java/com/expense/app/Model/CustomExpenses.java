package com.expense.app.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


public class CustomExpenses {
    @SequenceGenerator(
            name = "ce_sequence",
            sequenceName = "ce_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ce_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private Expensive expensive;
}
