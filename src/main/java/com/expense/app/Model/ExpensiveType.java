package com.expense.app.Model;

public enum ExpensiveType {
    CREDIT,DEBIT;

    public String toString() {
        switch (this) {
            case CREDIT:
                return "Credit";
            case DEBIT:
                return "Debit";
        }
        return "";
    }
}
