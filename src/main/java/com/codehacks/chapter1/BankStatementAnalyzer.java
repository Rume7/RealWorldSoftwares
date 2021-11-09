package com.codehacks.chapter1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 *
 * @author Rhume
 */
public class BankStatementAnalyzer {
    
    public void analyze(final String fileName, final BankStatementParser bankStatementParser)
                                                throws IOException {

        final Path path = Paths.get(fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + 
                bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transactions in January is " + 
                bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        
        System.out.println("Transactions in February is " + 
                bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));

        System.out.println("The total salary received is " + 
                bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
