package de.tanuki_hardware_store.currency_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CurrencyServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void currencyConversionTestCase1() throws Exception {
		final String baseUrl = "http://localhost:"+port+"/convert";
		URI uri = new URI(baseUrl);
		Request request = new Request("EUR","USD",5);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<Request> httpRequest = new HttpEntity<>(request, headers);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, httpRequest, String.class);

		String expectedJSON = "{\"price\":5.35,\"currency\":\"USD\"}";

		assertEquals(200, result.getStatusCodeValue());
		assertEquals(expectedJSON,result.getBody());
	}

	@Test
	public void currencyConversionTestCase2() throws Exception {
		final String baseUrl = "http://localhost:"+port+"/convert";
		URI uri = new URI(baseUrl);
		Request request = new Request("GBP","JPY",3);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<Request> httpRequest = new HttpEntity<>(request, headers);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, httpRequest, String.class);

		String expectedJSON = "{\"price\":482.28,\"currency\":\"JPY\"}";

		assertEquals(200, result.getStatusCodeValue());
		assertEquals(expectedJSON,result.getBody());
	}

	@Test
	public void unsupportedCurrencyTest() throws Exception {
		final String baseUrl = "http://localhost:"+port+"/convert";
		URI uri = new URI(baseUrl);
		Request request = new Request("QQQ","JPY",3);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<Request> httpRequest = new HttpEntity<>(request, headers);

		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, httpRequest, String.class);

		String expectedMessage = "Currency QQQ is not supported.";

		assertEquals(400, result.getStatusCodeValue());
		assertEquals(expectedMessage,result.getBody());
	}

}
