package com.codehacks.chapter1;

import java.time.Month;
import java.util.List;

/**
 *
 * @author Rhume
 */
public class BankStatementProcessor {
    
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }
    
    public double calculateTotalAmount() {
        double total = 0;
        for (final BankTransaction eachTransaction : bankTransactions) {
            total += eachTransaction.getAmount();
        }
        return total;
    }
    
    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for (final BankTransaction eachTransaction : bankTransactions) {
            if (eachTransaction.getDate().getMonth() == month) {
                total += eachTransaction.getAmount();
            }
        }
        return total;
    }
    
    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (final BankTransaction eachTransaction : bankTransactions) {
            if (eachTransaction.getDesc().equals(category)) {
                total += eachTransaction.getAmount();
            }            
        }
        return total;
    }
}
