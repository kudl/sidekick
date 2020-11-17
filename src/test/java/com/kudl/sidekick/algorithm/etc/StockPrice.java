package com.kudl.sidekick.algorithm.etc;

import static org.assertj.core.api.Assertions.assertThat;

public class StockPrice {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] answer = {4, 3, 1, 1, 0};

		assertThat(new StockPrice().solution(prices)).isEqualTo(answer);
	}

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			int time = 1;
			for (int j = i + 1; j < prices.length; j++) {
				if(j + 1 == prices.length || prices[i] > prices[j]) {
					answer[i] = time;
					break;
				}
				time++;
			}
		}

		return answer;
	}
}
