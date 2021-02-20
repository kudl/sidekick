package com.kudl.sidekick.algorithm.stringnarray;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAnagramsMapping {

	public static void main(final String[] args) {
		final int[] A = {11, 27, 45, 31, 50};
		final int[] B = {50, 11, 31, 45, 27};
		final int[] answer = {1, 4, 3, 2, 0};

		assertThat(new FindAnagramsMapping().solution(A, B)).isEqualTo(answer);
	}

	private int[] solution(final int[] a, final int[] b) {
		final Map<Integer, Integer> mapper = new HashMap<>();
		final int[] answer = new int[a.length];

		for (int i = 0; i < b.length; i++) {
			mapper.put(b[i], i);
		}

		for (int i = 0; i < a.length; i++) {
			answer[i] = mapper.get(a[i]);
		}

		return answer;
	}
}
