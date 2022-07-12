package de.tanuki_hardware_store.currency_service;

import java.io.Serializable;

public class Result implements Serializable {

    private double price;
    private String currency;

    public Result(double price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public Result() {}

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
