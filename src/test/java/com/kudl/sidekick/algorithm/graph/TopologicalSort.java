package com.kudl.sidekick.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

	/**
	 * 위상 정렬
	 */
	public static void main(String[] args) {
		int courseNumber = 4;
		int[][] nums = {
				{1, 0},
				{2, 1},
				{3, 2}
		};

		TopologicalSort topologicalSort = new TopologicalSort();
		System.out.println(topologicalSort.solution(courseNumber, nums));
	}

	private boolean solution(int courseNumber, int[][] nums) {
		if (0 >= courseNumber) {
			return false;
		}

		// 1. inDegree 배열, Queue 생성
		Queue<Integer> queue = new LinkedList();
		int[] inDegree = new int[courseNumber];

		int numberLength = nums.length;

		for (int i = 0; i < numberLength; i++) {
			inDegree[nums[i][1]]++;
		}

		int inDegreeLength = inDegree.length;
		for (int i = 0; i < inDegreeLength; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int firstZero = queue.poll();

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
