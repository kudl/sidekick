package com.kudl.sidekick.algorithm.stringnarray;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {

	public static void main(String[] args) {
		int[][] points = {{1, 3}, {-2, 2}};
		int k = 1;

		int[][] answer = new KClosest().solution(points, k);

		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				System.out.print(answer[i][j]);
			}
		}
	}

	private int[][] solution(int[][] points, int k) {
//		Queue<int[]> queue = new PriorityQueue<>(points.length, Comp);
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
		int[][] result = new int[k][2];
		int index = 0;

		for (int[] point : points) {
			queue.offer(point);
		}

		while (index < k) {
			result[index] = queue.poll();
			index++;
		}

		return result;
	}

	Comparator<int[]> Comp = new Comparator<int[]>() {
		@Override
		public int compare(int[] a, int[] b) {
			return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
		}
	};
}
