package com.kudl.sidekick.algorithm.stringnarray;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveZeros {

	public static void main(final String[] args) {
		final int[] nums = {0, 3, 2, 0, 8, 5};
		final int[] answer = {3, 2, 8, 5, 0, 0};

		assertThat(new MoveZeros().solution(nums)).isEqualTo(answer);
	}

	private int[] solution(final int[] nums) {

		int index = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[index] = nums[i];
				index++;
			}
		}

		for (int i = index; i < nums.length; i++) {
			nums[index] = 0;
			index++;
		}

		return nums;
	}
}
