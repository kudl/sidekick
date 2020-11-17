package com.kudl.sidekick.algorithm.etc;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class TwoNumberSum {

	public static void main(String[] args) {
		int[] numbersV1 = {2, 1, 3, 4, 1};
		int[] resultV1 = {2, 3, 4, 5, 6, 7};

		int[] numbersV2 = {5, 0, 2, 7};
		int[] resultV2 = {2, 5, 7, 9, 12};

		int[] numbersV3 = {99,99};
		int[] resultV3 = {198};

		assertAll("TwoNumberSum",
				() -> assertThat(new TwoNumberSum().solution(numbersV1)).isEqualTo(resultV1),
				() -> assertThat(new TwoNumberSum().solution(numbersV2)).isEqualTo(resultV2),
				() -> assertThat(new TwoNumberSum().solution(numbersV3)).isEqualTo(resultV3)
		);
	}

	private int[] solution(int[] numbers) {
		Set<Integer> answer = new HashSet<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				answer.add(numbers[i] + numbers[j]);
			}
		}

		return answer.stream()
				.sorted()
				.mapToInt(Number::intValue)
				.toArray();
	}
}
