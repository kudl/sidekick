package com.kudl.sidekick.algorithm.stringnarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MeetingRoom2 {

	public static void main(final String[] args) {
		final int[][] meeting1 = {
				{0, 30},
				{5, 10},
				{15, 20}
		};
		final int answer1 = 2;

		final int[][] meeting2 = {
				{7, 10},
				{2, 4}
		};
		final int answer2 = 1;

		final MeetingRoom2 meetingRoom2 = new MeetingRoom2();
		assertAll("MeetingRoom2",
				() -> assertThat(meetingRoom2.solution(meeting1)).isEqualTo(answer1),
				() -> assertThat(meetingRoom2.solution(meeting2)).isEqualTo(answer2)
		);
	}

	private int solution(final int[][] meeting) {
		Arrays.sort(meeting, Comparator.comparingInt(o -> o[0]));

		int answer = 0;
		final Queue<int[]> queue = new PriorityQueue<>(meeting.length, (Comparator.comparingInt(o -> o[1])));

		for (int i = 0; i < meeting.length; i++) {
			while (!queue.isEmpty() && queue.peek()[1] <= meeting[i][0]) {
				queue.poll();
			}

			queue.offer(meeting[i]);
			answer = Math.max(answer, queue.size());
		}

		return answer;
	}
}
