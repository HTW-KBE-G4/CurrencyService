package com.ponent.currency_service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {

    @Test
    void conversionTestCase1() throws CurrencyNotSupportedException {
        double converted = Calculator.convertCurrency("EUR", 5, "USD");
        assertEquals(5.35, converted);
    }

    @Test
    void conversionTestCase2() throws CurrencyNotSupportedException {
        double converted = Calculator.convertCurrency("GBP", 3, "YPN");
        assertEquals(482.28, converted);
    }

    @Test
    void invalidInputCurrency() {
        try {
            double converted = Calculator.convertCurrency("QQQ", 3, "YPN");
            fail();
        } catch(CurrencyNotSupportedException ignored) {
            //Exception was thrown as expected
        }
    }

    @Test
    void invalidOutputCurrency() {
        try {
            double converted = Calculator.convertCurrency("GBP", 3, "QQQ");
            fail();
        } catch (CurrencyNotSupportedException ignored) {
            //Exception was thrown as expected
        }
    }
}
