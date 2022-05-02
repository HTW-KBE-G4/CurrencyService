package de.tanuki_hardware_store.currency_service;

public class Calculator {

    public static double convertCurrency(String inputCurrency, double inputValue, String outputCurrency) throws CurrencyNotSupportedException {
        double res;
        try {
            res = (Currency.valueOf(inputCurrency).usdConversion * inputValue);
        } catch(IllegalArgumentException e) {
            throw new CurrencyNotSupportedException(inputCurrency);
        }

        try {
            res = res / Currency.valueOf(outputCurrency).usdConversion;
        } catch(IllegalArgumentException e) {
            throw new CurrencyNotSupportedException(outputCurrency);
        }

        return Math.round(res * 100.0) / 100.0;
    }
}
