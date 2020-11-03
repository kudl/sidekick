package com.example.sidekick.inflearn.graph;

import java.util.*;

public class WordLadder {

	public static void main(String[] args) {
		String[] words = {"hot", "dot", "lot", "log", "cog"};
		List<String> wordList = Arrays.asList(words);

		WordLadder wordLadder = new WordLadder();
		System.out.println(wordLadder.solution("hit", "cog", wordList));
	}

	private int solution(String beginWord, String endWord, List<String> wordList) {
		if (wordList == null || !wordList.contains(endWord)) {
			return 0;
		}

		Queue<String> queue = new LinkedList<>();
		Set<String> dict = new HashSet<>(wordList);

		queue.offer(beginWord);
		dict.add(endWord);
		dict.remove(beginWord);

		int level = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				String str = queue.poll();

				if (str.equals(endWord)) {
					return level;
				}

				for (String neighbor : neighbors(str, wordList)) {
					queue.offer(neighbor);
				}
			}

			level++;
		}

		return level;
	}

	private List<String> neighbors(String str, List<String> wordList) {
		List<String> result = new ArrayList<>();
		Set<String> dict = new HashSet<>(wordList);

		for (int i = 0; i < str.length(); i++) {
			char[] chars = str.toCharArray();

			for (char ch = 'a'; ch <= 'z'; ch++) {
				chars[i] = ch;
				String word = new String(chars);
				if (dict.remove(word)) {
					result.add(word);
				}
			}
		}

		return result;
	}
}
