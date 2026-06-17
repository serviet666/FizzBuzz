package net.nico.fizzbuzz.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FizzBuzzServiceTest {

	FizzBuzzService fizzBuzzService;

	@BeforeEach
	void setUp() {
		fizzBuzzService = new FizzBuzzService();
	}

	@Test
	void compute_shouldReturnStr1ForMultipleOfInt1() {
		int int1 = 3;
		int int2 = 5;
		int limit = int1 * int2;
		String compute = fizzBuzzService.compute(int1, int2, limit, "fizz", "buzz");
		String[] split = compute.split(",");
		int cpt = 1;
		while (int1 * cpt < limit) {
			assertEquals("fizz", split[int1 * cpt++ - 1]);
		}
	}

	@Test
	void compute_shouldReturnStr2ForMultipleOfInt2() {
		int int1 = 3;
		int int2 = 5;
		int limit = int1 * int2;
		String compute = fizzBuzzService.compute(int1, int2, limit, "fizz", "buzz");
		String[] split = compute.split(",");
		int cpt = 1;
		while (int2 * cpt < limit) {
			assertEquals("buzz", split[int2 * cpt++ - 1]);
		}
	}

	@Test
	void compute_shouldReturnStr1Str2ForMultipleOf1AndInt2() {
		int int1 = 3;
		int int2 = 5;
		int limit = int1 * int2;
		String compute = fizzBuzzService.compute(int1, int2, limit, "fizz", "buzz");
		String[] split = compute.split(",");
		assertEquals("fizzbuzz", split[limit - 1]);
	}

	@Test
	void compute_shouldReturnItselfForNoMultipleOfInt1OrInt2() {
		int int1 = 3;
		int int2 = 5;
		int limit = int1 * int2;
		String compute = fizzBuzzService.compute(int1, int2, limit, "fizz", "buzz");
		String[] split = compute.split(",");
		for (int i = 1; i <= limit; ++i) {
			if (i % int1 != 0 && i % int2 != 0) {
				assertEquals(Integer.toString(i), split[i - 1]);
			}
		}
	}

	@Test
	void compute_shouldReturnOneWhenLimitIsOne() {
		int int1 = 3;
		int int2 = 5;
		int limit = 1;
		String compute = fizzBuzzService.compute(int1, int2, limit, "fizz", "buzz");
		assertEquals("1", compute);
	}

	@Test
	void compute_shouldThrowWhenInt1IsNotPositive() {
		int int1 = 0;
		int int2 = 5;
		int limit = 15;
		assertThrows(IllegalArgumentException.class, () -> fizzBuzzService.compute(int1, int2, limit, "fizz", "buzz"));
	}

	@Test
	void compute_shouldThrowWhenInt2IsNotPositive() {
		int int1 = 3;
		int int2 = 0;
		int limit = 15;
		assertThrows(IllegalArgumentException.class, () -> fizzBuzzService.compute(int1, int2, limit, "fizz", "buzz"));
	}

	@Test
	void compute_shouldThrowWhenStr1IsBlank() {
		int int1 = 3;
		int int2 = 5;
		int limit = int1 * int2;
		assertThrows(IllegalArgumentException.class, () -> fizzBuzzService.compute(int1, int2, limit, "", "buzz"));
	}

	@Test
	void compute_shouldThrowWhenStr2IsBlank() {
		int int1 = 3;
		int int2 = 5;
		int limit = int1 * int2;
		assertThrows(IllegalArgumentException.class, () -> fizzBuzzService.compute(int1, int2, limit, "fizz", ""));
	}

	@Test
	void compute_shouldThrowWhenLimitIsZero() {
		int int1 = 3;
		int int2 = 5;
		int limit = 0;
		assertThrows(IllegalArgumentException.class, () -> fizzBuzzService.compute(int1, int2, limit, "fizz", "buzz"));
	}
}
