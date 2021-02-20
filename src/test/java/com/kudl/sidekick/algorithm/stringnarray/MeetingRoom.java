package com.kudl.sidekick.algorithm.stringnarray;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MeetingRoom implements Serializable {

	private static final long serialVersionUID = -6767916596312429120L;

	public static void main(final String[] args) {
		final int[][] intervals1 = {
				{15, 20},
				{5, 10},
				{0, 30}
		};
		final boolean answer1 = false;

		final int[][] intervals2 = {
				{7, 10},
				{2, 4}
		};
		final boolean answer2 = true;

		assertAll("MeetingRoom",
				() -> assertThat(new MeetingRoom().solution(intervals1)).isEqualTo(answer1),
				() -> assertThat(new MeetingRoom().solution(intervals2)).isEqualTo(answer2)
		);
	}

	private boolean solution(final int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i - 1][1] > intervals[i][0]) {
				return false;
			}
		}

		return true;
	}
}
