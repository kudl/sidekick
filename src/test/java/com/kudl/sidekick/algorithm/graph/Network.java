package com.kudl.sidekick.algorithm.graph;

public class Network {

	public static void main(final String[] args) {
		final int n = 3;
		final int[][] computers = {
				{1, 1, 0},
				{1, 1, 0},
				{0, 0, 0}
		};

//		final int[][] computers = {
//				{1, 1, 0},
//				{1, 1, 1},
//				{0, 1, 1}
//		};

		System.out.println(new Network().solution(n, computers));
	}

	public int solution(final int n, final int[][] computers) {
		int answer = 0;
		final boolean[] check = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				answer++;
				dfs(computers, check, i);
			}
		}

		return answer;
	}

	void dfs(final int[][] computers, final boolean[] check, final int start) {
		check[start] = true;

		for (int i = 0; i < computers.length; i++) {
			if (computers[start][i] == 1 && !check[i]) {
				dfs(computers, check, i);
			}
		}
	}
}
