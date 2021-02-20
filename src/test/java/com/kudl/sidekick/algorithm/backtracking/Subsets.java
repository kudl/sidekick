package com.kudl.sidekick.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static void main(final String[] args) {
		final int[] nums = {1, 2, 3};

		System.out.println(new Subsets().solution(nums));
	}

	private List<List<Integer>> solution(final int[] nums) {
		final List<List<Integer>> answerGroup = new ArrayList<>();
		final List<Integer> answer = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return answerGroup;
		}

		dfs(answerGroup, answer, nums, 0);

		return answerGroup;
	}

	private void dfs(final List<List<Integer>> answerGroup, final List<Integer> answer, final int[] nums, final int start) {
		final List<Integer> result = new ArrayList<>(answer);
		answerGroup.add(result);

		for (int i = start; i < nums.length; i++) {
			answer.add(nums[i]);
			dfs(answerGroup, answer, nums, i + 1);
			answer.remove(answer.size() - 1);
		}
	}
}
