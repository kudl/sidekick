package com.kudl.sidekick.algorithm.dp;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;

		CoinChange coinChange = new CoinChange();
		System.out.println(coinChange.solution(coins, amount));
	}

	private int solution(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[max];
		Arrays.fill(dp, max);
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if(i >= coins[j]) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}
}
