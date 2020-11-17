package com.kudl.sidekick.algorithm.etc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class NoSameNumber {

	public static void main(String[] args) {
		int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
		int[] answer1 = {1, 3, 0, 1};

		int[] arr2 = {4, 4, 4, 3, 3};
		int[] answer2 = {4, 3};

		NoSameNumber noSameNumber = new NoSameNumber();
		assertAll("NoSameNumber",
				() -> assertThat(noSameNumber.solution(arr1)).isEqualTo(answer1),
				() -> assertThat(noSameNumber.solution(arr2)).isEqualTo(answer2)
		);
	}

	public int[] solution(int[] arr) {
		List<Integer> arrayList = new ArrayList<>();
		int preNum = 10;

		for (int num : arr) {
			if (preNum != num) {
				arrayList.add(num);
			}
			preNum = num;
		}

		int[] answer = new int[arrayList.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = arrayList.get(i);
		}

		return answer;
	}
}
