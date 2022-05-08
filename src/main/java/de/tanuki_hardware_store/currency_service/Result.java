package de.tanuki_hardware_store.currency_service;

public class Result {

    private final double price;
    private final String currency;

    public Result(double price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

}
