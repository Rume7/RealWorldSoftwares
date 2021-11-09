package com.codehacks.chapter1;

import java.util.List;

/**
 *
 * @author Rhume
 */
public interface BankStatementParser {
    
    BankTransaction parseFrom(String line) ;
    
    List<BankTransaction> parseLinesFrom(List<String> lines);
    
}
