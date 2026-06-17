package net.nico.fizzbuzz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.nico.fizzbuzz.service.FizzBuzzService;

@Configuration
public class FizzBuzzConfiguration {

	@Bean
	FizzBuzzService fizzBuzzService() {
		return new FizzBuzzService();
	}

}
