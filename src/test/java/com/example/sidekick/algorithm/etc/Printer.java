package com.example.sidekick.algorithm.etc;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Printer {

	public static void main(String[] args) {
		int[] prioritiesV1 = {2, 1, 3, 2};
		int locationV1 = 2;
		int answerV1 = 1;

		int[] prioritiesV2 = {1, 1, 9, 1, 1, 1};
		int locationV2 = 0;
		int answerV2 = 5;

		Printer printer = new Printer();
		assertAll("Printer",
				() -> assertThat(printer.solution(prioritiesV1, locationV1)).isEqualTo(answerV1),
				() -> assertThat(printer.solution(prioritiesV2, locationV2)).isEqualTo(answerV2)
		);
	}

	public int solution(int[] priorities, int location) {
		int answer = 1;
		Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < priorities.length; i++) {
			queue.add(priorities[i]);
		}

		while (!queue.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (priorities[i] == queue.peek()) {
					if (i == location) {
						return answer;
					}
					queue.poll();
					answer++;
				}
			}
		}

		return answer;
	}
}
