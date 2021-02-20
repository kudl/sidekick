package com.kudl.sidekick.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(final String[] args) {
		final int[] nums = {1, 2, 3};

		System.out.println(new Permutation().solution(nums));
	}

	private List<List<Integer>> solution(final int[] nums) {
		final List<List<Integer>> answer = new ArrayList<>();
		final List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return answer;
		}

		dfs(nums, answer, list);

		return answer;
	}

	private void dfs(final int[] nums, final List<List<Integer>> answer, final List<Integer> current) {
		if (current.size() == nums.length) {
			final List<Integer> list = new ArrayList<>(current);
			answer.add(list);
		}

		for (int i = 0; i < nums.length; i++) {
			if (current.contains(nums[i])) {
				continue;
			}

			current.add(nums[i]);
			dfs(nums, answer, current);
			current.remove(current.size() - 1);
		}
	}
}
