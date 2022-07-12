package de.tanuki_hardware_store.currency_service;

import java.io.Serializable;

public class CurrencyServiceRequest implements Serializable {
    private String inputCurrency;
    private String expectedCurrency;
    private double value;

    public CurrencyServiceRequest(String inputCurrency, String expectedCurrency, double value) {
        this.inputCurrency = inputCurrency;
        this.expectedCurrency = expectedCurrency;
        this.value = value;
    }

    public CurrencyServiceRequest() {}

    public String getInputCurrency() {
        return inputCurrency;
    }

    public String getExpectedCurrency() {
        return expectedCurrency;
    }

    public double getValue() {
        return value;
    }

    public void setExpectedCurrency(String expectedCurrency) {
        this.expectedCurrency = expectedCurrency;
    }

    public void setInputCurrency(String inputCurrency) {
        this.inputCurrency = inputCurrency;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
