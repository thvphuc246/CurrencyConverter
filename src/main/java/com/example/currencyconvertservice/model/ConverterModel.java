package com.example.currencyconvertservice.model;

public class ConverterModel {
    private String baseCurrency;
    private String targetCurrency;
    private double srcAmount;
    private double targetAmount;

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getSrcAmount() {
        return srcAmount;
    }

    public void setSrcAmount(double srcAmount) {
        this.srcAmount = srcAmount;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }
}
