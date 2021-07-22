package com.example.currencyconvertservice.service;

import com.example.currencyconvertservice.model.ConverterModel;
import com.example.currencyconvertservice.model.ResponseModel;

public interface ConverterService {
    public ResponseModel getConvertedValue(String source, String target, double amount);
    public ConverterModel getConverterModel();
}
