package com.kudl.sidekick.algorithm.stringnarray;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MissingRange {

	public static void main(final String[] args) {
		final int[] nums = {2, 3, 5, 50, 75};
		final int lower = 0;
		final int upper = 99;

		final String[] answer = {
				"0 -> 1",
				"4",
				"6 -> 49",
				"51 -> 74",
				"76 -> 99"
		};

		assertThat(new MissingRange().solution(nums, lower, upper)).isEqualTo(answer);
	}

	private String[] solution(final int[] nums, final int lower, final int upper) {
		final List<String> answer = new ArrayList<>();

		if (lower < nums[0]) {
			answer.add(makeRange(lower, nums[0] - 1));
		}

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1] && nums[i] + 1 < nums[i + 1]) {
				answer.add(makeRange(nums[i] + 1, nums[i + 1] - 1));
			}
		}

		if (nums[nums.length - 1] < upper) {
			answer.add(makeRange(nums[nums.length - 1] + 1, upper));
		}

		return answer.toArray(new String[0]);
	}

	private String makeRange(final int low, final int high) {
		return low == high ? String.valueOf(low) : (low + " -> " + high);
	}
}
