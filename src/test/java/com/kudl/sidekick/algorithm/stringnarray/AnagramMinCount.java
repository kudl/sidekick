package com.kudl.sidekick.algorithm.stringnarray;

import static java.lang.Math.abs;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class AnagramMinCount {

	public static void main(final String[] args) {

		final String a1 = "rather";
		final String b1 = "harder";
		final int answer1 = 2;

		final String a2 = "apple";
		final String b2 = "pear";
		final int answer2 = 3;

		final String a3 = "lemon";
		final String b3 = "melon";
		final int answer3 = 0;

		final AnagramMinCount anagramMinCount = new AnagramMinCount();
		assertAll("anagramMinCount",
				() -> assertThat(anagramMinCount.solution(a1, b1)).isEqualTo(answer1),
				() -> assertThat(anagramMinCount.solution(a2, b2)).isEqualTo(answer2),
				() -> assertThat(anagramMinCount.solution(a3, b3)).isEqualTo(answer3)
		);
	}

	private int solution(final String str1, final String str2) {
		int answer = 0;
		final int[] chars = new int[26];

		for (int i = 0; i < str1.length(); i++)
			chars[str1.charAt(i) - 'a']++;

		for (int i = 0; i < str2.length(); i++) {
			chars[str2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; ++i) {
			if (chars[i] != 0) {
				answer += abs(chars[i]);
			}
		}

		return answer;
	}
}
