package net.nico.fizzbuzz.service;

import java.util.StringJoiner;

public class FizzBuzzService {

	public String compute(int int1, int int2, int limit, String str1, String str2) {
		if (int1 <= 0 || int2 <= 0 || limit <= 0) {
			throw new IllegalArgumentException("int1, int2 et limit doivent être strictement positifs");
		}
		if (str1 == null || str1.isBlank() || str2 == null || str2.isBlank()) {
			throw new IllegalArgumentException("str1 et str2 ne doivent pas être vides");
		}
		StringJoiner stringJoiner = new StringJoiner(",");
		for (int i = 1; i <= limit; ++i) {
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
		return stringJoiner.toString();
	}

}
