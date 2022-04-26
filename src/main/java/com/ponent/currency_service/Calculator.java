package com.ponent.currency_service;

public class Calculator {

    public static double convertCurrency(String inputCurrency, double inputValue, String outputCurrency) throws CurrencyNotSupportedException {
        try {
            double res = (Currency.valueOf(inputCurrency).usdConversion * inputValue) / Currency.valueOf(outputCurrency).usdConversion;
            return Math.round(res * 100.0) / 100.0;
        } catch(IllegalArgumentException e) {
            throw new CurrencyNotSupportedException();
        }
    }
}
