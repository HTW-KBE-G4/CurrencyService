package de.tanuki_hardware_store.currency_service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class CurrencyServer {


    @RabbitListener(queues = "currency")
    public String receive(CurrencyServiceRequest req) throws CurrencyNotSupportedException {
        double res = Calculator.convertCurrency(req.getInputCurrency(),req.getValue(),req.getExpectedCurrency());
        Result result = new Result(res,req.getExpectedCurrency());
        String resultString = "";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            resultString = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("[Receive] sending resultString: <"+resultString+">");

        return resultString;
    }
}
