package com.lomianki;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyModel {
    //stwórz model waluty na podstawie wywołania api: localhost:3001/currencies
    @JsonProperty("symbol")
    		private String symbol;
    @JsonProperty("name")
            private String name;
    @JsonProperty("symbol_native")
            private String symbol_native;
    @JsonProperty("decimal_digits")
            private int decimal_digits;
    @JsonProperty("rounding")
            private int rounding;
    @JsonProperty("code")
            private String code;
    @JsonProperty("name_plural")
            private String name_plural;

        public String getSymbol() {
                return symbol;
        }

        public String getName() {
                return name;
        }

        public String getCode() {
                return code;
        }

    @Override
    public String toString() {
        return "CurrencyModel{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
