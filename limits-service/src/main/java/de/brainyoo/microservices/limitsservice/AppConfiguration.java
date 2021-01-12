package de.brainyoo.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("limits-service")
@Component
@Getter
@Setter
public class AppConfiguration {
	private int minimum;
	private int maximum;
}
