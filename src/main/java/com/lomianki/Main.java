package com.lomianki;


import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter.convert(Currency.USD, Currency.PLN);
        ExchangeOffice exchangeOffice = new ExchangeOffice(1000);
        exchangeOffice.showFunds();
        exchangeOffice.exchange(100, Currency.EUR, Currency.PLN);
        exchangeOffice.showFunds();

        exchangeOffice.exchange(300, Currency.EUR, Currency.PLN);
        exchangeOffice.showFunds();
    }
}