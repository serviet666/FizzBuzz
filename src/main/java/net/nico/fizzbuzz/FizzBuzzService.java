package net.nico.fizzbuzz;

import java.util.StringJoiner;

public class FizzBuzzService {

	public String compute(int int1, int int2, int limit, String str1, String str2) {
		StringJoiner stringJoiner = new StringJoiner(",");
		for (int i = 1; i <= limit; i++) {
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
