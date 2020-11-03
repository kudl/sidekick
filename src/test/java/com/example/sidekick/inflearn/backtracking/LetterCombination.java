package com.example.sidekick.inflearn.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

	public static void main(String[] args) {
		String digitLetter[] = {"", "", "abc", "def", "ghi"};
		String digits = "23";

		System.out.println(new LetterCombination().solution(digitLetter, digits));
	}

	private List<String> solution(String[] digitLetter, String digits) {
		List<String> answer = new ArrayList<>();

		if (digitLetter.length == 0) {
			return answer;
		}

		answer.add("");

		for (int i = 0; i < digits.length(); i++) {
			answer = combine(answer, digitLetter[digits.charAt(i) - '0']);
		}

		return answer;
	}

	private List<String> combine(List<String> answer, String digits) {
		List<String> combineGroup = new ArrayList<>();

		for (int i = 0; i < digits.length(); i++) {
			for (String s : answer) {
				combineGroup.add(s + digits.charAt(i));
			}
		}

		return combineGroup;
	}
}
