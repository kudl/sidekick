package com.example.sidekick.algorithm.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 2, 5, 2, 6, 10, 4, 12};

		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.solution(nums));
	}

	private int solution(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int result = 1;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}

			result = Math.max(result, dp[i]);
		}

		return result;
	}
}
