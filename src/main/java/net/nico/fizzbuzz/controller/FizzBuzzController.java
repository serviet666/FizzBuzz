package net.nico.fizzbuzz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FizzBuzzController {

	@GetMapping
	public ResponseEntity<String> get(int int1, int int2, int limit, String str1, String str2) {
		return ResponseEntity.ok().build();
	}

}
