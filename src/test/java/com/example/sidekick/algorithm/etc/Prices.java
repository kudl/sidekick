package com.example.sidekick.algorithm.etc;

import static org.assertj.core.api.Assertions.assertThat;

public class Prices {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		assertThat(new Prices().solution(prices)).isEqualTo(new int[]{4, 3, 1, 1, 0});
	}

	private int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < answer.length; i++) {
			for (int j = i + 1; j < answer.length; j++) {
				if (prices[i] > prices[j]) {
					answer[i] = j - i;
					break;
				}
				if (j == answer.length - 1) answer[i] = j - i;
			}
		}

		return answer;
	}
}
