
# CurrencyService

Takes a currency + value input and converts it into a a different currency.

## Currency Exchange Rate Calculator

This Service listens on Rabbit RPC-Queues defined in the following file: [RabbitMQConfig](src/main/java/de/tanuki_hardware_store/currency_service/RabbitMQConfig.java).

Following Request is expected as JSON: [CurrencyServiceRequest](src/main/java/de/tanuki_hardware_store/currency_service/CurrencyServiceRequest.java)
 
The Result is described in the following file: [Result](src/main/java/de/tanuki_hardware_store/currency_service/Result.java)
