package com.example.sidekick.algorithm.etc;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GiveUpMath {

	public static void main(String[] args) {
		int[] answersV1 = {1, 2, 3, 4, 5};
		int[] answerV1 = {1};

		int[] answersV2 = {1, 3, 2, 4, 2};
		int[] answerV2 = {1, 2, 3};


		GiveUpMath giveUpMath = new GiveUpMath();
		assertAll("GiveUpMath",
				() -> assertThat(giveUpMath.solution(answersV1)).isEqualTo(answerV1),
				() -> assertThat(giveUpMath.solution(answersV2)).isEqualTo(answerV2)
		);
	}

	private int[] solution(int[] answers) {
		int[] person1 = {1, 2, 3, 4, 5};
		int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int answersLength = answers.length;
		int[] hit = new int[3];
		for (int i = 0; i < answersLength; i++) {
			if (answers[i] == person1[i % answersLength]) {
				hit[0]++;
			}

			if (answers[i] == person2[i % answersLength]) {
				hit[1]++;
			}

			if (answers[i] == person3[i % answersLength]) {
				hit[2]++;
			}
		}

		int max = Math.max(hit[0], Math.max(hit[1], hit[2]));

		ArrayList<Integer> list = new ArrayList<>();
		if (max == hit[0]) {
			list.add(1);
		}

		if (max == hit[1]) {
			list.add(2);
		}

		if (max == hit[2]) {
			list.add(3);
		}

		return list.stream().mapToInt(i -> i.intValue()).toArray();
	}
}
