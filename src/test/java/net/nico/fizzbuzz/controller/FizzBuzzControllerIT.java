package net.nico.fizzbuzz.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import net.nico.fizzbuzz.service.FizzBuzzService;

@WebMvcTest
class FizzBuzzControllerIT {
	
	@Autowired
	MockMvc mockMvc;

	@MockBean
	FizzBuzzService fizzBuzzService;

	@Test
	void get_shouldReturn200WithResult() throws Exception {
		when(fizzBuzzService.compute(3, 5, 15, "fizz", "buzz")).thenReturn("1,2,fizz,4,buzz");
		mockMvc.perform(get("/api/fizzbuzz")
				.param("int1", "3")
				.param("int2", "5")
				.param("limit", "15")
				.param("str1", "fizz")
				.param("str2", "buzz"))
			.andExpect(status().isOk())
			.andExpect(content().string("1,2,fizz,4,buzz"));
	}

	@Test
	void get_shouldReturn200WithoutParametersWithResult() throws Exception {
		when(fizzBuzzService.compute(3, 5, 100, "Fizz", "Buzz")).thenReturn("1,2,fizz,4,buzz");
		mockMvc.perform(get("/api/fizzbuzz"))
			.andExpect(status().isOk());
	}

	@Test
	void get_shouldReturn400WhenInt1IsNotAnInteger() throws Exception {
		mockMvc.perform(get("/api/fizzbuzz")
				.param("int1", "abc")
				.param("int2", "5")
				.param("limit", "15")
				.param("str1", "fizz")
				.param("str2", "buzz"))
			.andExpect(status().isBadRequest());
	}

	@Test
	void get_shouldReturn400WhenInt1IsNotPositive() throws Exception {
		mockMvc.perform(get("/api/fizzbuzz")
				.param("int1", "0")
				.param("int2", "5")
				.param("limit", "15")
				.param("str1", "fizz")
				.param("str2", "buzz"))
			.andExpect(status().isBadRequest());
	}

	@Test
	void get_shouldReturn400WhenStr1IsBlank() throws Exception {
		mockMvc.perform(get("/api/fizzbuzz")
				.param("int1", "3")
				.param("int2", "5")
				.param("limit", "15")
				.param("str1", "")
				.param("str2", "buzz"))
			.andExpect(status().isBadRequest());
	}
}
