package com.example.currencyconvertservice.model;

import java.util.Map;

public class ConversionRate {
    private String date;
    private String base;
    private Map<String, String> rates;

    public String getDate() {
        return date;
    }

    public String getBase() {
        return base;
    }

    public Map<String, String> getRates() {
        return rates;
    }
}
