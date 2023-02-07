package io.spring.ajeer.cashierhelperservice.model;

import java.util.TreeMap;

public class CurrencyMappings {
    private TreeMap<String, Currency> currencyMappings;
    public CurrencyMappings(){}
    public CurrencyMappings(TreeMap<String, Currency> currencyMappings){
        this.currencyMappings = currencyMappings;
    }
    public TreeMap<String, Currency> getCurrencyMappings() {
        return currencyMappings;
    }
    public void setCurrencyMappings(TreeMap<String, Currency> currencyMappings) {
        this.currencyMappings = currencyMappings;
    }
}
