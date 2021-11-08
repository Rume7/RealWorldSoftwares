package com.codehacks.chapter1;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Rhume
 */
public class BankTransaction {
    
    private final LocalDate date;
    private final double amount;
    private final String desc;

    public BankTransaction(LocalDate date, double amount, String desc) {
        this.date = date;
        this.amount = amount;
        this.desc = desc;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, desc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final BankTransaction that = (BankTransaction) obj;
        return Double.compare(that.amount, amount) == 0 && 
                date.equals(that.date) && desc.equals(that.desc);
    }
    
    
    
    
}
