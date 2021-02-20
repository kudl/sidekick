package com.kudl.sidekick.algorithm.graph;

public class TargetNumber {
	public static void main(final String[] args) {
		final int[] numbers = {1, 1, 1, 1};
		final int target = 3;

		System.out.println(new TargetNumber().solution(numbers, target));

	}

	public int solution(final int[] numbers, final int target) {
		int answer = 0;
		answer = dfs(numbers, 0, 0, target);
		return answer;
	}

	int dfs(final int[] numbers, final int n, final int sum, final int target) {
		if (n == numbers.length) {
			if (sum == target) {
				return 1;
			}
			return 0;
		}
		return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
	}
}
