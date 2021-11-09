package com.codehacks.chapter1;

import java.io.IOException;

/**
 *
 * @author Rhume
 */
public class MainApplication {
    
    private static final String RESOURCES = "src/main/java/statement.txt";
    
    public static void main(String[] args) throws IOException {
        
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
        
        bankStatementAnalyzer.analyze(RESOURCES, bankStatementParser);
    }    
}
