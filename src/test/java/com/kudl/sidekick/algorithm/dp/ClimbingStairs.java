package com.kudl.sidekick.algorithm.dp;

public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 3;

		ClimbingStairs climbingStairs = new ClimbingStairs();
		System.out.println(climbingStairs.solution(n));
	}

	private int solution(int n) {
		int[] dp = new int[n + 1];
		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}
}
