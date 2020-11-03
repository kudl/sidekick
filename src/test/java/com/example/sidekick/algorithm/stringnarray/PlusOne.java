package com.example.sidekick.algorithm.stringnarray;

public class PlusOne {

	public static void main(String[] args) {
//		int[] digits = {1,2,3};
		int[] digits = {9,9,9};
//		int[] digits = {0, 1, 2};

		int[] answer = new PlusOne().solution(digits);

		for (int i : answer) {
			System.out.println(i);
		}
	}

	private int[] solution(int[] digits) {

		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				break;
			}

			if (i == 0) {
				int[] answer = new int[digits.length + 1];
				answer[0] = 1;
				return answer;
			}
		}

		return digits;
	}
}
