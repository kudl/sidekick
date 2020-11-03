package com.example.sidekick.inflearn.stringnarray;

import java.util.*;

public class Anagram {

	public static void main(String[] args) {
		String[] strGroup = {"eat", "tea", "tan", "ate", "nat", "bat"};

		System.out.println(new Anagram().solution(strGroup));
	}

	private List<List<String>> solution(String[] strGroup) {
		List<List<String>> answer = new ArrayList<>();
		Map<String, List<String>> wordMap = new HashMap<>();

		for (String str : strGroup) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);

			String key = String.valueOf(charArray);
			if(wordMap.containsKey(key)) {
				wordMap.get(key).add(str);
			} else {
				List<String> wordGroup = new ArrayList<>();
				wordGroup.add(str);
				wordMap.put(key, wordGroup);
			}
		}

		answer.addAll(wordMap.values());
		return answer;
	}
}
