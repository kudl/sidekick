package com.kudl.sidekick.algorithm.stringnarray;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class KthLargestNumber {

	public static void main(final String[] args) {
		final int[] nums = {3, 2, 1, 5, 6, 4};
		final int answer = 5;

		assertThat(new KthLargestNumber().solution(nums)).isEqualTo(answer);
	}

	private int solution(final int[] nums) {
		final Queue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < nums.length; i++) {
			queue.offer(nums[i]);

			if (queue.size() > 2) {
				queue.poll();
			}
		}

		return queue.poll();
	}
}
