package com.ponent.currency_service;

public enum Currency {
    USD(1),
    GBP(1.27),
    SEK(0.1),
    EUR(1.07),
    JPY(0.0079);

    public final double usdConversion;

    private Currency(double usdConversion) {
        this.usdConversion = usdConversion;
    }
}
