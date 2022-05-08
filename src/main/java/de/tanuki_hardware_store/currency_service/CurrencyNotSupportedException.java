package de.tanuki_hardware_store.currency_service;

public class CurrencyNotSupportedException extends Exception {
    private final String unsupportedCurrency;

    public CurrencyNotSupportedException(String currency) {
        this.unsupportedCurrency = currency;
    }

    public String getUnsupportedCurrency() {
        return unsupportedCurrency;
    }
}
