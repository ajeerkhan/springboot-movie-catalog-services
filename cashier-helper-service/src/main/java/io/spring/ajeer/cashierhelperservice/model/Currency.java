package io.spring.ajeer.cashierhelperservice.model;

import java.util.TreeMap;

public class Currency {
    private String code;
    private String symbol;
    private TreeMap<Double, String> denominations;

    public Currency() {}

    public Currency(String code, String symbol, TreeMap<Double, String> denominations) {
        this.code = code;
        this.symbol = symbol;
        this.denominations = denominations;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public TreeMap<Double, String> getDenominations() {
        return denominations;
    }

    public void setDenominations(TreeMap<Double, String> denominations) {
        this.denominations = denominations;
    }
}
