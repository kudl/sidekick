package com.example.sidekick.inflearn.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};

		System.out.println(new Permutation().solution(nums));
	}

	private List<List<Integer>> solution(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return answer;
		}

		dfs(nums, answer, list);

		return answer;
	}

	private void dfs(int[] nums, List<List<Integer>> answer, List<Integer> current) {
		if (current.size() == nums.length) {
			List<Integer> list = new ArrayList<>(current);
			answer.add(list);
		}

		for (int i = 0; i < nums.length; i++) {
//			모두 뽑기
//			if(current.size() == nums.length) {
//				continue;
//			}

			if (current.contains(nums[i])) {
				continue;
			}

			current.add(nums[i]);
			dfs(nums, answer, current);
			current.remove(current.size() - 1);
		}
	}
}
