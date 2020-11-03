package com.example.sidekick.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	/**
	 * 부분 집합
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};

		System.out.println(new Subsets().solution(nums));
	}

	private List<List<Integer>> solution(int[] nums) {
		List<List<Integer>> answerGroup = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return answerGroup;
		}

		dfs(answerGroup, answer, nums, 0);

		return answerGroup;
	}

	private void dfs(List<List<Integer>> answerGroup, List<Integer> answer, int[] nums, int start) {
		List<Integer> result = new ArrayList<>(answer);
		answerGroup.add(result);

		for (int i = start; i < nums.length; i++) {
			answer.add(nums[i]);
			dfs(answerGroup, answer, nums, i + 1);
			answer.remove(answer.size() - 1);
		}
	}
}
