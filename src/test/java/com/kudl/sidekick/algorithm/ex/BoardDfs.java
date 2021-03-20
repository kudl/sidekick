package com.kudl.sidekick.algorithm.ex;

import java.util.ArrayList;
import java.util.List;

public class BoardDfs {

	public static void main(final String[] args) {
//		final int[][] board = {
//				{0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
//				{0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
//				{0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
//				{0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
//				{0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
//				{0, 0, 0, 0, 3, 0, 0, 0, 1, 0}
//		};

		final int[][] board = {
				{0, 2, 0},
				{1, 1, 1},
				{0, 1, 1},
				{0, 3, 0}
		};

		final int c = 1;

		System.out.println(new BoardDfs().solution(board, c));
	}

	int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	int m, n;

	private int solution(final int[][] board, final int c) {
		final int answer = 0;

		m = board.length;
		n = board[0].length;

		final int[] start = new int[2];
		final int[] dest = new int[2];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 2) {
					start[0] = i;
					start[1] = j;
				}

				if (board[i][j] == 3) {
					dest[0] = i;
					dest[1] = j;
				}
			}
		}

		if (start[0] == dest[0] && start[1] == dest[1]) {
			return answer;
		}

		final List<Integer> a = new ArrayList<>();

		for (final int[] dir : dirs) {
			final int x = start[0];
			final int y = start[1];
			final boolean[][] visited = new boolean[m][n];
			visited[start[0]][start[1]] = true;
			dfs(board, new int[]{x + dir[0], y + dir[1]}, dest, visited, 0, c, a);
		}

		return answer;
	}

	private int dfs(final int[][] board, final int[] start, final int[] dest, final boolean[][] visited, int answer, final int c, final List<Integer> answers) {
		if (start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n || visited[start[0]][start[1]]) {
			return answer;
		}

		visited[start[0]][start[1]] = true;
		if (start[0] == dest[0] && start[1] == dest[1]) {
			answers.add(answer);
			answer = 0;
			return answer;
		}

		answer += board[start[0]][start[1]] == 1 ? 1 + c : 1;

		for (final int[] dir : dirs) {
			answer = dfs(board, new int[]{start[0] + dir[0], start[1] + dir[1]}, dest, visited, answer, c, answers);
		}

		return answer;
	}
}
