package com.example.sidekick.inflearn.graph;

import java.util.*;

public class RemoveInvalidParams {

	public static void main(String[] args) {
		String s = "(a)())()";

		RemoveInvalidParams removeInvalidParams = new RemoveInvalidParams();
		System.out.println(removeInvalidParams.solution(s));
	}

	private List<String> solution(String s) {
		List<String> result = new ArrayList<>();
		if (s == null) {
			return result;
		}

		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.offer(s);
		visited.add(s);
		boolean found = false;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String str = queue.poll();
				if (isValidStr(str)) {
					result.add(str);
					found = true;
				}

				if (found) {
					continue;
				}

				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(j) != '(' && str.charAt(j) != ')') {
						continue;
					}

					String newStr = str.substring(0, j) + str.substring(j + 1);
					if (!visited.contains(newStr)) {
						queue.offer(newStr);
						visited.add(newStr);
					}
				}
			}
		}

		return result;
	}

	private boolean isValidStr(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;

				// ()))(
				if (count < 0) {
					return false;
				}
			}
		}

		return count == 0;
	}
}
