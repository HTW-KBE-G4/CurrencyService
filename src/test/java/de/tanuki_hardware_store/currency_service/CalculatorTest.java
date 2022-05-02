package de.tanuki_hardware_store.currency_service;

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
        double converted = Calculator.convertCurrency("GBP", 3, "JPY");
        assertEquals(482.28, converted);
    }

    @Test
    void invalidInputCurrency() {
        try {
            double converted = Calculator.convertCurrency("QQQ", 3, "JPY");
            fail();
        } catch(CurrencyNotSupportedException e) {
            //Exception was thrown as expected
            assertEquals("QQQ", e.getUnsupportedCurrency());
        }
    }

    @Test
    void invalidOutputCurrency() {
        try {
            double converted = Calculator.convertCurrency("GBP", 3, "QQQ");
            fail();
        } catch (CurrencyNotSupportedException e) {
            //Exception was thrown as expected
            assertEquals("QQQ", e.getUnsupportedCurrency());
        }
    }
}
