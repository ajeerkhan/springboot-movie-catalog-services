package io.spring.ajeer.cashierhelperservice.resources;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.ajeer.cashierhelperservice.model.BalanceResponse;
import io.spring.ajeer.cashierhelperservice.model.Currency;
import io.spring.ajeer.cashierhelperservice.model.CurrencyMappings;
import io.spring.ajeer.cashierhelperservice.service.BalanceProcessor;

@RestController
@RequestMapping("/balance-as-change")
public class CashierHelperResource {
    @Autowired
    private CurrencyMappings currencyMappings;
    
    @RequestMapping("/{currency}/{amount}/")
    public BalanceResponse getPrintableBalance(@PathVariable("currency") String currencyName, @PathVariable("amount") Double amount) {
       TreeMap<String, Currency> currencyTreeMap  = currencyMappings.getCurrencyMappings();
       Currency currency = currencyTreeMap.get(currencyName.toUpperCase());
       if(currency != null) {
           return new BalanceResponse(currencyName, amount,BalanceProcessor.changeCoinMessage(amount, currency.getDenominations(), ""));
       }
       return new BalanceResponse(currencyName, amount, "Currency type not supported."); 
    }
}
