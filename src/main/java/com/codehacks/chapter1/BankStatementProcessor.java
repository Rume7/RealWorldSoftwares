package com.codehacks.chapter1;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    public int numberOfTransactionsInAMonth(final Month month) {
        int noOfTransactions = 0;
        
        for (final BankTransaction transaction : bankTransactions) {
            if (transaction.getDate().getMonth() == month) {
                noOfTransactions++;
            }
        }        
        return noOfTransactions;
    }
    
    public Map<Month, Integer> numOfTransactionsPerMonth() {
        Map<Month, Integer> monthTransactions = new HashMap<>();
        
        bankTransactions.stream().map(transaction -> transaction.getDate().getMonth()).forEachOrdered(month -> {
            if (monthTransactions.containsKey(month)) {
                int frequency = monthTransactions.get(month);
                monthTransactions.put(month, frequency+1);
            } else {
                monthTransactions.put(month, 1);
            }
        });
        return monthTransactions;
    }
}
