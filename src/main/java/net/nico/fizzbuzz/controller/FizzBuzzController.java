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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import net.nico.fizzbuzz.service.FizzBuzzService;

@Validated
@RestController
@RequestMapping("/api")
@Tag(name = "FizzBuzz", description = "Generates a generic FizzBuzz sequence")
public class FizzBuzzController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final FizzBuzzService fizzBuzzService;

	public FizzBuzzController(FizzBuzzService fizzBuzzService) {
		this.fizzBuzzService = Objects.requireNonNull(fizzBuzzService);
	}

	@Operation(summary = "Generate a FizzBuzz sequence",
			description = "Returns a comma-separated sequence from 1 to limit (inclusive). "
					+ "Multiples of int1 are replaced by str1, multiples of int2 by str2, "
					+ "and multiples of both by str1+str2.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Sequence generated successfully",
					content = @Content(mediaType = "text/plain",
							examples = @ExampleObject(value = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz"))),
			@ApiResponse(responseCode = "400", description = "Invalid parameter",
					content = @Content(mediaType = "text/plain",
							examples = @ExampleObject(value = "must be greater than 0")))
	})
	@GetMapping("/fizzbuzz")
	public ResponseEntity<String> get(
			@Parameter(description = "First divisor (strictly positive)", example = "3")
			@RequestParam(defaultValue = "3") @Positive int int1,
			@Parameter(description = "Second divisor (strictly positive)", example = "5")
			@RequestParam(defaultValue = "5") @Positive int int2,
			@Parameter(description = "Upper bound of the sequence, inclusive (strictly positive)", example = "100")
			@RequestParam(defaultValue = "100") @Positive int limit,
			@Parameter(description = "String to display for multiples of int1", example = "Fizz")
			@RequestParam(defaultValue = "Fizz") @NotBlank String str1,
			@Parameter(description = "String to display for multiples of int2", example = "Buzz")
			@RequestParam(defaultValue = "Buzz") @NotBlank String str2) {
		logger.debug("FizzBuzz request: int1={}, int2={}, limit={}, str1={}, str2={}", int1, int2, limit, str1, str2);
		return ResponseEntity.ok(fizzBuzzService.compute(int1, int2, limit, str1, str2));
	}

}
