package com.example.sidekick.inflearn.graph;

public class NumberOfIsland {

	public static void main(String[] args) {
		char[][] grid = {
				{'1', '1', '1', '0', '1'},
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '1'},
				{'0', '0', '0', '0', '1'}
		};

		System.out.println(new NumberOfIsland().solution(grid));
	}

	private int solution(char[][] grid) {
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		prints(grid);
		return count;
	}

	int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	private void dfs(char[][] grid, int i, int j) {
		int m = grid.length;
		int n = grid[0].length;

		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
			return;
		}

		grid[i][j] = 'X';

		for (int[] dir : dirs) {
			dfs(grid, i + dir[0], j + dir[1]);
		}
	}

	private void prints(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}
