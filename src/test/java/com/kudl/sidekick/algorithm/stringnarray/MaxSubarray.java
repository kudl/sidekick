package com.kudl.sidekick.algorithm.stringnarray;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxSubarray {

	public static void main(final String[] args) {
		final int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		final int answer = 6;

		assertThat(new MaxSubarray().solution(nums)).isEqualTo(answer);
	}

	private int solution(final int[] nums) {

		int sum = nums[0];
		int max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], sum + nums[i]);
			max = Math.max(sum, max);
		}

		return max;
	}
}
