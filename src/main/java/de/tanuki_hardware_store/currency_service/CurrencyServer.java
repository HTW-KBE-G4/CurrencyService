package de.tanuki_hardware_store.currency_service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;



public class CurrencyServer {

    @RabbitListener(queues = "currency")
    public Result receive(Request req) throws CurrencyNotSupportedException {
        double res = Calculator.convertCurrency(req.getInputCurrency(),req.getValue(),req.getExpectedCurrency());
        return new Result(res,req.getExpectedCurrency());
    }
}
