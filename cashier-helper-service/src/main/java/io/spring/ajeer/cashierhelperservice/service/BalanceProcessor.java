package io.spring.ajeer.cashierhelperservice.service;

import java.util.Map;
import java.util.TreeMap;

public class BalanceProcessor {
    public static String changeCoinMessage(Double amount, TreeMap<Double, String> treeMap, String output) {
        if (amount == 0) return "ZERO";
        if (amount < 0) return "ERROR";
        Map.Entry<Double, String> lowEntry = treeMap.floorEntry(amount); //find the next denominator which can divide the given value;
        Double numberOfNotes = Math.floor(amount / lowEntry.getKey());
        output = output + numberOfNotes.intValue() + " " + lowEntry.getValue() + "";
        Double remainder = amount - (lowEntry.getKey() * numberOfNotes);
        if (remainder == 0 || treeMap.floorEntry(remainder) == null) return output;
        return changeCoinMessage(amount - (lowEntry.getKey() * numberOfNotes), treeMap, output + ", ");
    }
}
