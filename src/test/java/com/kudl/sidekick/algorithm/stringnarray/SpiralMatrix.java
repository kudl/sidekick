package com.kudl.sidekick.algorithm.stringnarray;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SpiralMatrix {

	public static void main(final String[] args) {
		final int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		final int[] answer = {1, 2, 3, 6, 9, 8, 7, 4, 5};

		assertThat(new SpiralMatrix().solution(matrix)).isEqualTo(answer);
	}

	private int[] solution(final int[][] matrix) {
		final List<Integer> answer = new ArrayList<>();
		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		int colStart = 0;
		int colEnd = matrix[0].length - 1;


		while (rowStart <= rowEnd && colStart <= colEnd) {
			// right 00, 01, 02, 03
			for (int i = colStart; i <= colEnd; i++) {
				answer.add(matrix[rowStart][i]);
			}
			rowStart++;

			// down 03, 13, 23
			for (int i = rowStart; i <= rowEnd; i++) {
				answer.add(matrix[i][colEnd]);
			}
			colEnd--;

			// left 33, 32, 31
			if (rowStart <= rowEnd) {
				for (int i = colEnd; i >= colStart; i--) {
					answer.add(matrix[rowEnd][i]);
				}
				rowEnd--;
			}

			// up 30, 20, 10
			if (colStart <= colEnd) {
				for (int i = rowEnd; i >= rowStart; i--) {
					answer.add(matrix[i][colStart]);
				}
				colStart++;
			}
		}

		return answer
				.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}
}
