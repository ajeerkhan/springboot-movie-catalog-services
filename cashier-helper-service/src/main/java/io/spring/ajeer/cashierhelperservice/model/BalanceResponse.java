package io.spring.ajeer.cashierhelperservice.model;

public class BalanceResponse {
    private String currency;
    private Double amount;
    private String balanceAsText;
    public BalanceResponse(String currency, Double amount, String balanceAsText) {
        this.currency = currency;
        this.amount = amount;
        this.balanceAsText = balanceAsText;
    }

    public String getCurrency() {
        return currency;
    }
    public Double getAmount() {
        return amount;
    }
    public String getBalanceAsText() {
        return balanceAsText;
    }
}
