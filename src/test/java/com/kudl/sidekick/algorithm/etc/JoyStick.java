package com.kudl.sidekick.algorithm.etc;

public class JoyStick {
	public static void main(String[] args) {
		String name1 = "JAZ";
		int answer1 = 11;

		String name2 = "JEROEN";
		int answer2 = 56;

		String name3 = "JAN";
		int answer3 = 23;

		System.out.println(Character.toString("BA".charAt(0) + 25) + "A");

		JoyStick joyStick = new JoyStick();
//		assertAll("JoyStick",
//				() -> assertThat(joyStick.solution(name1)).isEqualTo(answer1),
//				() -> assertThat(joyStick.solution(name2)).isEqualTo(answer2),
//				() -> assertThat(joyStick.solution(name3)).isEqualTo(answer3)
//		);
	}

	public int solution(String name) {
		int answer = 0;
		String start = "AAA";

		int count = 0;
		dfs(start, count, name);

		return answer;
	}

	private void dfs(String start, int count, String name) {
		if(start.equals(name)) {
			return;
		}

		count++;
		dfs(Character.toString("AA".charAt(0) + 1), count, name);
		dfs(start.charAt(0) + 1 + start.substring(1), count, name);
	}
}
