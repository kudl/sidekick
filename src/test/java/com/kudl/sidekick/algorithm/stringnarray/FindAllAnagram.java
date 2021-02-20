package com.kudl.sidekick.algorithm.stringnarray;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAllAnagram {

	public static void main(final String[] args) {
		final String txt = "BACDGABCDA";
		final String pat = "ABCD";
		final int[] answer = {0, 5, 6};

		assertThat(new FindAllAnagram().solution(txt, pat)).isEqualTo(answer);
	}

	private int[] solution(final String txt, final String pat) {
		final List<Integer> answer = new ArrayList<>();

		final int[] patArray = new int[256];
		for (int i = 0; i < pat.length(); i++) {
			patArray[pat.charAt(i)]++;
		}

		for (int i = 0; i < txt.length() - pat.length() + 1; i++) {
			final int[] txtArray = new int[256];
			for (int j = 0; j < pat.length(); j++) {
				txtArray[txt.charAt(i + j)]++;
			}

			if (check(patArray, txtArray)) {
				answer.add(i);
			}
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private boolean check(final int[] patArray, final int[] txtArray) {
		for (int i = 0; i < patArray.length; i++) {
			if (patArray[i] != txtArray[i]) {
				return false;
			}
		}

		return true;
	}
}
