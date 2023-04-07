package com.lomianki;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CurrencyConverter {
    private static final String API_KEY = "68e25a244e5c38d99944f3aa";

    public static double convert(Currency from, Currency to) {
        String baseURL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/"
                + from.getName() + "/" + to.getName();
        String value;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(getResponse(baseURL));
            value = jsonNode.get("conversion_rate").toString();
        } catch (IOException e) {
            throw new NullPointerException(e.getMessage());
        }
        return Double.parseDouble(value);
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
}