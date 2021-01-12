package de.brainyoo.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean conversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> vars = new HashMap<>();
		vars.put("from", from);
		vars.put("to", to);
		ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, vars);
		CurrencyConversionBean body = response.getBody();
		return new CurrencyConversionBean(body.getId(), from, to, body.getConversionMultiple(), quantity,
				quantity.multiply(body.getConversionMultiple()));
	}
}
