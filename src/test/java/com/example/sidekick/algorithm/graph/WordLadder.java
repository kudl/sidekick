package com.example.sidekick.algorithm.graph;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WordLadder {

	public static void main(String[] args) {
		WordLadder wordLadder = new WordLadder();

		String beginV1 = "hit";
		String targetV1 = "cog";
		String[] wordsV1 = {"hot", "dot", "lot", "log", "cog"};
		int answerV1 = 4;

		String beginV2 = "hit";
		String targetV2 = "cog";
		String[] wordsV2 = {"hot", "dot", "dog", "lot", "log"};
		int answerV2 = 0;

		assertAll("WordLadder",
				() -> assertThat(wordLadder.solution(beginV1, targetV1, wordsV1)).isEqualTo(answerV1),
				() -> assertThat(wordLadder.solution(beginV2, targetV2, wordsV2)).isEqualTo(answerV2)
		);
	}

	private int solution(String begin, String target, String[] words) {
		List<String> wordList = Arrays.asList(words);

		if (wordList == null || !wordList.contains(target)) {
			return 0;
		}

		Queue<String> queue = new LinkedList<>();
		Set<String> dict = new HashSet<>(wordList);

		queue.offer(begin);
		dict.add(target);
		dict.remove(begin);

		int level = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				String str = queue.poll();

				if (str.equals(target)) {
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
