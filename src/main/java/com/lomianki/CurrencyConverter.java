package com.lomianki;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CurrencyConverter {
    private static final String API_KEY="68e25a244e5c38d99944f3aa";

    public static double convert(Currency from, Currency to) {
        StringBuilder stringBuilder = new StringBuilder();
        String value = "0.00";
        String baseURL = "https://v6.exchangerate-api.com/v6/"+ API_KEY+"/pair/"
                + from.getName() + "/" + to.getName();
        try {
            URL url = new URL(baseURL);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            //System.out.println(stringBuilder);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(stringBuilder.toString());
            value = jsonNode.get("conversion_rate").toString();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.out.println("Sprawdz czy działa server.");
        }
        return Double.parseDouble(value);
    }
}

