package de.tanuki_hardware_store.currency_service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class CurrencyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyServiceApplication.class, args);
	}

	@PostMapping("/convert")
	public String convert(@RequestBody Request request) throws JsonProcessingException, CurrencyNotSupportedException {
		ObjectMapper objectMapper = new ObjectMapper();
		double res = Calculator.convertCurrency(request.getInputCurrency(), request.getValue(), request.getExpectedCurrency());
		return objectMapper.writeValueAsString(new Result(res, request.getExpectedCurrency()));
	}

	@ExceptionHandler(CurrencyNotSupportedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleCurrencyNotSupportedException(
			CurrencyNotSupportedException exception
	) {
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body("Currency " + exception.getUnsupportedCurrency()+" is not supported.");
	}

}
