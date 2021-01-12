package de.brainyoo.microservices.limitsservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LimitsConfiguration {
	private int maximum;
	private int minimum;
}
