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
public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/main/java/statement.txt";
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public static void main(final String... args) throws IOException {

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions
                = bankStatementParser.parseLinesFrom(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + 
                bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transactions in January " + 
                bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        
        System.out.println("Transactions in February is " + 
                bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));

        System.out.println("The total salary received is " + 
                bankStatementProcessor.calculateTotalForCategory("Salary"));
        
    }
}
