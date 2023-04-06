package com.lomianki;

public enum Currency {
    USD("USD"),
    PLN("PLN"),
    JPY("JPY"),
    EUR("EUR"),
    GBP("GBP"),
    CZK("CZK"),
    CHF("CHF"),
    COP("COP");

    private final String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
