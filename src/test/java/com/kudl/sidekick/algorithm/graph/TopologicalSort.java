package com.kudl.sidekick.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
	public static void main(final String[] args) {
		final int courseNumber = 4;
		final int[][] nums = {
				{1, 0},
				{2, 1},
				{3, 2}
		};

		final TopologicalSort topologicalSort = new TopologicalSort();
		System.out.println(topologicalSort.solution(courseNumber, nums));
	}

	private boolean solution(final int courseNumber, final int[][] nums) {
		if (0 >= courseNumber) {
			return false;
		}

		// 1. inDegree, Queue
		final Queue<Integer> queue = new LinkedList();
		final int[] inDegree = new int[courseNumber];

		final int numberLength = nums.length;

		for (int i = 0; i < numberLength; i++) {
			inDegree[nums[i][1]]++;
		}

		final int inDegreeLength = inDegree.length;
		for (int i = 0; i < inDegreeLength; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			final int firstZero = queue.poll();

			for (int i = 0; i < numberLength; i++) {
				if (firstZero == nums[i][0]) {
					inDegree[nums[i][1]]--;
					if (inDegree[nums[i][1]] == 0) {
						queue.offer(nums[i][1]);
					}
				}
			}
		}

		for (int i = 0; i < inDegreeLength; i++) {
			if (inDegree[i] != 0) {
				return false;
			}
		}

		return true;
	}
}
