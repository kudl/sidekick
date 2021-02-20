package com.kudl.sidekick.algorithm.stringnarray;

import static org.assertj.core.api.Assertions.assertThat;

public class TrappingRainWater {

	public static void main(final String[] args) {
		final int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		final int answer = 6;

		assertThat(new TrappingRainWater().solution(height)).isEqualTo(answer);
	}

	private int solution(final int[] height) {
		int answer = 0;
		final int[] left = new int[height.length];
		final int[] right = new int[height.length];

		int max = height[0];
		left[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			if (max > height[i]) {
				left[i] = max;
			} else {
				left[i] = height[i];
				max = height[i];
			}
		}

		max = height[height.length - 1];
		right[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			if (max > height[i]) {
				right[i] = max;
			} else {
				right[i] = height[i];
				max = height[i];
			}
		}

		for (int i = 0; i < height.length; i++) {
			answer += Math.min(left[i], right[i]) - height[i];
		}

		return answer;
	}
}
