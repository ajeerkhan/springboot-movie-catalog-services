package io.spring.ajeer.cashierhelperservice;

import java.util.TreeMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.spring.ajeer.cashierhelperservice.model.Currency;
import io.spring.ajeer.cashierhelperservice.model.CurrencyMappings;

@SpringBootApplication
public class CashierHelperServiceApplication {

	/*
	private static final TreeMap<Double, String> treeMap = new TreeMap<>() {{
        put(0.01, "PENNY");
        put(0.05, "NICKEL");
        put(0.10, "DIME");
        put(0.25, "QUARTER");
        put(0.50, "HALF DOLLAR");
        put(1.00, "ONE");
        put(2.00, "TWO");
        put(5.00, "FIVE");
        put(10.00, "TEN");
        put(20.00, "TWENTY");
        put(50.00, "FIFTY");
        put(100.00, "ONE HUNDRED");
    }};
    public static void main(String[] args) {
        assertEquals("ERROR", changeCoinMessage((double) -10, treeMap, ""));
        assertEquals("ZERO", changeCoinMessage((double) 0, treeMap, ""));
        assertEquals("1 FIFTY", changeCoinMessage(50.0, treeMap, ""));
        assertEquals("1 ONE HUNDRED", changeCoinMessage(100.0, treeMap, ""));
        assertEquals("1 ONE HUNDRED 1 FIFTY", changeCoinMessage(150.0, treeMap, ""));
        assertEquals("1 HALF DOLLAR 1 QUARTER", changeCoinMessage(0.75, treeMap, ""));
    }
    public static String changeCoinMessage(Double amount, TreeMap<Double, String> treeMap, String output) {
        if (amount == 0) return "ZERO";
        if (amount < 0) return "ERROR";
        Map.Entry<Double, String> lowEntry = treeMap.floorEntry(amount);
        Double numberOfNotes = Math.floor(amount / lowEntry.getKey());
        output = output + numberOfNotes.intValue() + " " + lowEntry.getValue() + "";
        if (amount - (lowEntry.getKey() * numberOfNotes) == 0) return output;
        return changeCoinMessage(amount - (lowEntry.getKey() * numberOfNotes), treeMap, output + " ");
    }
	*/

	@Bean
	public CurrencyMappings getCurrencyMappingConfiguration() {
		final TreeMap<String, Currency> currencyMappings = new TreeMap<String, Currency>();
		Currency inr = new Currency("INR", "INR ₹", new TreeMap<Double, String>(){{
			put(100.00, "ONE HUNDRED");
			put(50.00, "FIFTY");
			put(20.00, "TWENTY");
			put(10.00, "TEN");
			put(5.00, "FIVE");
			put(1.00, "ONE");
			put(.50, "FIFTY PAISE");
			put(.25, "TWENTY FIVE PAISE");
		}});
		Currency aed = new Currency("AED", "AED", new TreeMap<Double, String>(){{
			put(100.00, "ONE HUNDRED");
			put(50.00, "FIFTY");
			put(20.00, "TWENTY");
			put(10.00, "TEN");
			put(5.00, "FIVE");
			put(1.00, "ONE");
			put(.50, "FIFTY FILS");
			put(.25, "TWENTY FIVE FILS");
		}});
		Currency dollar = new Currency("USD", "US$", new TreeMap<Double, String>(){{
			put(100.00, "ONE HUNDRED");
			put(50.00, "FIFTY");
			put(20.00, "TWENTY");
			put(10.00, "TEN");
			put(5.00, "FIVE");
			put(2.00, "TWO");
			put(1.00, "ONE");
			put(.1, "ONE CENT");
		}});
		currencyMappings.put(inr.getCode(), inr);
		currencyMappings.put(aed.getCode(), aed);
		currencyMappings.put(dollar.getCode(), dollar);
		return  new CurrencyMappings(currencyMappings);
	}

	public static void main(String[] args) {
		SpringApplication.run(CashierHelperServiceApplication.class, args);
	}

}
