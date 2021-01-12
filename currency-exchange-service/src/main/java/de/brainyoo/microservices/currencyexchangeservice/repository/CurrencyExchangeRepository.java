package de.brainyoo.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.brainyoo.microservices.currencyexchangeservice.entity.ExchangeValue;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
}
