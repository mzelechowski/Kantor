package com.lomianki;

import java.util.HashMap;
import java.util.Map;

public class ExchangeOffice {
    private Map<Currency, Double> availableFounds;

    public ExchangeOffice(double balance) {
        this.availableFounds=new HashMap<>();
        for (Currency currency : Currency.values()) {
            availableFounds.put(currency, balance);
        }
    }

    public void showFunds() {
        System.out.print("Current funds: \n");
        for(Map.Entry<Currency,Double> entry : availableFounds.entrySet()){
            System.out.print(String.format("%.2f", entry.getValue())+" "+entry.getKey()+" \n");
        }
    }

    public void exchange(double amount, Currency from, Currency to){
        double available=availableFounds.get(to);
        double need=amount*0.8*CurrencyConverter.convert(from, to);
        if(available>= need){
            availableFounds.put(from, availableFounds.get(from)+amount);
            availableFounds.put(to, availableFounds.get(to)-need);
            System.out.println("\nExchanging: "+amount + " "
                    +from.getName()+ " to "+ String.format("%.2f", need) + " " + to.getName());
        } else {
            System.out.println("\nCannot exhanged " + amount + " "
                    + from.getName() + " to "+ String.format("%.2f", need) + " "+ to.getName() + " insufficent founds");
        }
    }
}
