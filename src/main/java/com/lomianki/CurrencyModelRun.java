package com.lomianki;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrencyModelRun {
    public static void main(String[] args) {
        for(CurrencyModel c: getCurrencies()){
            System.out.println(c.getName()+ " "+c.getCode()+ " "+c.getSymbol());
        }
        CurrencyModelRun.getCurrenciesId().forEach(System.out::println);
        for(CurrencyModel c: getCurrencies()){
            System.out.println(c.toString());
        }

    }
    public static List<CurrencyModel> getCurrencies(){
        String baseURL = "http://localhost:3003/currencies";
        String responseBody= getResponse(baseURL);
        List<CurrencyModel> currencyModels;
        try {
            currencyModels = Arrays.asList(new ObjectMapper().readValue(responseBody,CurrencyModel[].class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return currencyModels;
    }

    private static String getResponse(String sourceURL) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(sourceURL);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
    //// napisz metodę zwracjącą kolekjcę Stringów z kolekcją samych currencyID, użyj metody getCurrencies

    private static List<String> getCurrenciesId(){
        List<String> currenciesID = new ArrayList<>();
        for(CurrencyModel c:getCurrencies()) {
            currenciesID.add(c.getCode());
        }
        return currenciesID;
    }
}


