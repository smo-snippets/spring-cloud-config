package de.brainyoo.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.brainyoo.microservices.currencyexchangeservice.entity.ExchangeValue;
import de.brainyoo.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	CurrencyExchangeRepository repository;

	@Autowired
	private Environment environment;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeVal = repository.findByFromAndTo(from, to);
		exchangeVal.setPort(environment.getProperty("local.server.port"));
		return exchangeVal;
	}

	@RequestMapping(value = "/")
	public String ping() {
		return "home";
	}
}
