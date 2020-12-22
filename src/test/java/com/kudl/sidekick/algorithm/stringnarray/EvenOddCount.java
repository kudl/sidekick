package com.kudl.sidekick.algorithm.stringnarray;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class EvenOddCount {

	public static void main(final String[] args) {
		final int[] a1 = {2, 7, 4, 6, 3, 1};
		final boolean answer1 = true;

		final int[] a2 = {-1, 1};
		final boolean answer2 = false;

		final int[] a3 = {2, -1};
		final boolean answer3 = true;

		final int[] a4 = {1, 2, 4, 3};
		final boolean answer4 = true;

		final int[] a5 = {-1, -3, 4, 7, 7, 7};
		final boolean answer5 = false;

		final EvenOddCount evenOddCount = new EvenOddCount();

		assertAll("evenOddCount",
				() -> assertThat(evenOddCount.solution(a1)).isEqualTo(answer1),
				() -> assertThat(evenOddCount.solution(a2)).isEqualTo(answer2),
				() -> assertThat(evenOddCount.solution(a3)).isEqualTo(answer3),
				() -> assertThat(evenOddCount.solution(a4)).isEqualTo(answer4),
				() -> assertThat(evenOddCount.solution(a5)).isEqualTo(answer5)

		);
	}

	private boolean solution(final int[] a) {
		final int n = a.length;

		if (n % 2 == 1)
			return false;

		int oddCount = 0, evenCount = 0;

		for (int i = 0; i < n; i++) {
			if (a[i] % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
		}

		return evenCount == oddCount;
	}
}
