package com.kudl.sidekick.algorithm.stringnarray;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PlusOne {

	public static void main(final String[] args) {
		final int[] digits1 = {1, 2, 3};
		final int[] answer1 = {1, 2, 4};

		final int[] digits2 = {9, 9, 9};
		final int[] answer2 = {1, 0, 0, 0};

		final int[] digits3 = {9, 8, 9};
		final int[] answer3 = {9, 9, 0};

		final PlusOne plusOne = new PlusOne();
		assertAll("PlusOne",
				() -> assertThat(plusOne.solution(digits1)).isEqualTo(answer1),
				() -> assertThat(plusOne.solution(digits2)).isEqualTo(answer2),
				() -> assertThat(plusOne.solution(digits3)).isEqualTo(answer3)
		);
	}

	private int[] solution(int[] digits) {
		int index = digits.length - 1;
		int carry = 1;

		while (index >= 0 && carry > 0) {
			digits[index] = (digits[index] + 1) % 10;

			if (digits[index] == 0) {
				carry = 1;
			} else {
				carry = 0;
			}

			--index;
		}

		if (carry == 1) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
		}

		return digits;
	}
}
