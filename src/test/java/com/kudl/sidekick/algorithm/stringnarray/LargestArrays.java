package com.kudl.sidekick.algorithm.stringnarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestArrays {

	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 5, 6, 4};
		int k = 2;

		System.out.println(new LargestArrays().solution(nums, k));
		System.out.println(new LargestArrays().solutionV2(nums, k));
	}

	private int solution(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
		for (int num : nums) {
			queue.offer(num);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.peek();
	}

	private int solutionV2(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}
