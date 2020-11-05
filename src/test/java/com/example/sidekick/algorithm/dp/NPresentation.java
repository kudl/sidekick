package com.example.sidekick.algorithm.dp;

import static org.assertj.core.api.Assertions.assertThat;

public class NPresentation {
	public static void main(String[] args) {
		assertThat(new NPresentation().solution(5, 12)).isEqualTo(4);
		assertThat(new NPresentation().solution(2, 11)).isEqualTo(3);
	}

	int answer = -1;

	public int solution(int N, int number) {
		dfs(N, number, 0, 0, "");
		return answer;
	}

	private void dfs(int N, int number, int count, int prevNumber, String expression) {
		int tempNumber = N;

		if (count > 8) {
			answer = -1;
			return;
		}

		if (number == prevNumber) {
			if (answer == -1 || answer > count) {
				System.out.println(expression);
				answer = count;
			}

			return;
		}

		for (int i = 0; i < 8 - count; i++) {
			dfs(N, number, count + i + 1, prevNumber - tempNumber, expression + "-");
			dfs(N, number, count + i + 1, prevNumber + tempNumber, expression + "+");
			dfs(N, number, count + i + 1, prevNumber * tempNumber, expression + "*");
			dfs(N, number, count + i + 1, prevNumber / tempNumber, expression + "/");
			tempNumber = increaseTempNumber(tempNumber, N);
		}
	}

	private int increaseTempNumber(int tempNumber, int N) {
		return tempNumber * 10 + N;
	}
}
