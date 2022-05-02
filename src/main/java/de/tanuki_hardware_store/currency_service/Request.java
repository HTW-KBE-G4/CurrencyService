package de.tanuki_hardware_store.currency_service;

public class Request {
    private String inputCurrency;
    private String expectedCurrency;
    private double value;

    public Request(String inputCurrency, String expectedCurrency, double value) {
        this.inputCurrency = inputCurrency;
        this.expectedCurrency = expectedCurrency;
        this.value = value;
    }

    public String getInputCurrency() {
        return inputCurrency;
    }

    public String getExpectedCurrency() {
        return expectedCurrency;
    }

    public double getValue() {
        return value;
    }
}
