package com.example.sidekick.inflearn.stringnarray;

public class RainWater {

	/**
	 * 벽돌의 배열이 주어질때 채울수 있는 물의 양 구하기
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

		System.out.println(new RainWater().solution(nums));
	}

	private int solution(int[] nums) {
		int answer = 0;
		if (nums == null || nums.length <= 2) {
			return answer;
		}

		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		left[0] = nums[0];
		int max = left[0];

		for (int i = 1; i < nums.length; i++) {
			if (max < nums[i]) {
				left[i] = nums[i];
				max = nums[i];
			} else {
				left[i] = max;
			}
		}

		right[nums.length - 1] = nums[nums.length - 1];
		max = right[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			if (max < nums[i]) {
				right[i] = nums[i];
				max = nums[i];
			} else {
				right[i] = max;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			answer += Math.min(left[i], right[i]) - nums[i];
		}

		return answer;
	}
}
