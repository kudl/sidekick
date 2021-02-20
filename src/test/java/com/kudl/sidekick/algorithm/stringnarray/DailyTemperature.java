package com.kudl.sidekick.algorithm.stringnarray;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class DailyTemperature {
	public static void main(final String[] args) {
		final int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
		final int[] answer = {1, 1, 4, 2, 1, 1, 0, 0};

		assertThat(new DailyTemperature().solution(nums)).isEqualTo(answer);
	}

	private int[] solution(final int[] nums) {
		final Stack<Integer> stack = new Stack<>();
		final int[] answer = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				final int index = stack.pop();
				answer[index] = i - index;
			}

			stack.push(i);
		}

		return answer;
	}
}
