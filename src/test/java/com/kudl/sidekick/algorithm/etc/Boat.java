package com.kudl.sidekick.algorithm.etc;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Boat {

	public static void main(String[] args) {
		int[] people1 = {70, 50, 80, 50};
		int limit1 = 100;
		int answer1 = 3;

		int[] people2 = {70, 80, 50};
		int limit2 = 100;
		int answer2 = 3;

		Boat boat = new Boat();
		assertAll("Boat",
				() -> assertThat(boat.solution(people1, limit1)).isEqualTo(answer1),
				() -> assertThat(boat.solution(people2, limit2)).isEqualTo(answer2)
		);
	}

	public int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people);
		int i = 0;

		for (int j = people.length - 1; i <= j; j--) {
			if(people[j] + people[i] <= limit) {
				i++;
			}

			answer++;
		}

		return answer;
	}
}
