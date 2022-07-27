# CurrencyService

Takes a currency + value input and converts it into a a different currency.

## Currency Exchange Rate Calculator

POST /convert

Request Body Fields:
String inputCurrency + double value + String expectedCurrency

The inputCurrency and expectedCurrency fields take ISO codes for the currency in question.
Currently supported: USD, GBP, SEK, EUR, JPY
