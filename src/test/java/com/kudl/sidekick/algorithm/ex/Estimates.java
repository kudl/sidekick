package com.kudl.sidekick.algorithm.ex;

public class Estimates {

	public static void main(String[] args) {
		int[] estimates = {5, 1, 9, 8, 10, 5};
		int k = 3;

//		int[] estimates = {10, 1, 1, 4, 3, 10};
//		int k = 6;

//		int[] estimates = {10, 1, 10, 1, 1, 4, 3, 10};
//		int k = 6;

		System.out.println(new Estimates().solution(estimates, k));
	}

	private int solution(int[] estimates, int k) {
		int answer = 0;

		if(estimates == null || estimates.length == 0) {
			return answer;
		}

		int temp = 0;
		int estimatesLength = estimates.length == k ? 1 : estimates.length + 1 - k;
		for (int i = 0; i < estimatesLength; i++) {
			for (int j = i; j < i + k; j++) {
				temp += estimates[j];
			}
			answer = Math.max(answer, temp);
			temp = 0;
		}

		return answer;
	}
}
