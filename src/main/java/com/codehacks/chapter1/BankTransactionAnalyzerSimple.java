package com.codehacks.chapter1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
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

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
        double total = calculateTotalAmount(bankTransactions);

        System.out.println("The total for all transactions is " + total);

        System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY).toString());
    }

    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        total = bankTransactions.stream().map(bankTransaction -> bankTransaction.getAmount())
                .reduce(total, (accumulator, _item) -> accumulator + _item);
        return total;
    }

    public static List<BankTransaction> selectInMonth(
            final List<BankTransaction> bankTransactions, final Month month) {

        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }

}
