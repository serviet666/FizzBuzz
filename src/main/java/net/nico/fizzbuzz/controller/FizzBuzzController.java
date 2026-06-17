package net.nico.fizzbuzz.controller;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import net.nico.fizzbuzz.service.FizzBuzzService;

@Validated
@RestController
@RequestMapping("/api")
public class FizzBuzzController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final FizzBuzzService fizzBuzzService;

	public FizzBuzzController(FizzBuzzService fizzBuzzService) {
		this.fizzBuzzService = Objects.requireNonNull(fizzBuzzService);
	}

	@GetMapping("/fizzbuzz")
	public ResponseEntity<String> get(
			@RequestParam(defaultValue = "3") @Positive int int1,
			@RequestParam(defaultValue = "5") @Positive int int2, 
			@RequestParam(defaultValue = "100") @Positive int limit,
			@RequestParam(defaultValue = "Fizz") @NotBlank String str1, 
			@RequestParam(defaultValue = "Buzz") @NotBlank String str2) {
		logger.debug("FizzBuzz request: int1={}, int2={}, limit={}, str1={}, str2={}", int1, int2, limit, str1, str2);
		return ResponseEntity.ok(fizzBuzzService.compute(int1, int2, limit, str1, str2));
	}

}
