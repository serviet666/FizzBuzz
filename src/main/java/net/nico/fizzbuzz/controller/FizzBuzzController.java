package net.nico.fizzbuzz.controller;

import java.util.StringJoiner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FizzBuzzController {

	@GetMapping("/test")
	public ResponseEntity<String> get(@RequestParam int int1, @RequestParam int int2, @RequestParam int limit,
			@RequestParam String str1, @RequestParam String str2) {
		StringJoiner stringJoiner = new StringJoiner(",");
		for (int i = 1; i < limit; i++) {
			if (i % int1 == 0 || i % int2 == 0) {
				StringBuilder stringBuilder = new StringBuilder(8);
				if (i % int1 == 0) {
					stringBuilder.append(str1);
				}
				if (i % int2 == 0) {
					stringBuilder.append(str2);
				}
				stringJoiner.add(stringBuilder);
			} else {
				stringJoiner.add(String.valueOf(i));
			}
			
		}
		return ResponseEntity.ok(stringJoiner.toString());
	}

}
