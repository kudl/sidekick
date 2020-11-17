package com.kudl.sidekick.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		int n = 3;

		GenerateParentheses generateParentheses = new GenerateParentheses();
		System.out.println(generateParentheses.solution(n));
	}

	int count = 0;

	private List<String> solution(int n) {
		List<String> result = new ArrayList<>();
		dfs(result, "", n, n, "");
		return result;
	}

	private void dfs(List<String> result, String str, int left, int right, String sample) {
		count++;

		System.out.println("str\t" + str + "\t left: " + left + "\t right: " + right + "\t sample: " + sample);

		if (left < 0 || left > right) {
			return;
		}

		if (left == 0 && right == 0) {
			result.add(str);
			return;
		}

		dfs(result, str + '(', left - 1, right, sample + "+");
		dfs(result, str + ')', left, right - 1, sample + "-");
	}
}
