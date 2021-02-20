package com.kudl.sidekick.algorithm.stringnarray;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeInterval {

	public static void main(final String[] args) {
		final List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));

		final List<Interval> answer = new ArrayList<>();
		answer.add(new Interval(1, 6));
		answer.add(new Interval(8, 10));
		answer.add(new Interval(15, 18));

		assertThat(new MergeInterval().solution(intervals)).isEqualTo(answer);
	}

	private List<Interval> solution(final List<Interval> intervals) {
		final List<Interval> answer = new ArrayList<>();

		Collections.sort(intervals, (Comparator.comparingInt(o -> o.start)));

		Interval before = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			final Interval current = intervals.get(i);

			if (before.end >= current.start) {
				before.end = Math.max(before.end, current.end);
			} else {
				answer.add(before);
				before = current;
			}
		}

		if (!answer.contains(before)) {
			answer.add(before);
		}

		return answer;
	}

	public static class Interval {
		private int start;
		private int end;

		private Interval() {
		}

		public Interval(final int start, final int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public boolean equals(final Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			final Interval interval = (Interval) o;
			return start == interval.start && end == interval.end;
		}

		@Override
		public int hashCode() {
			return Objects.hash(start, end);
		}

		@Override
		public String toString() {
			return "Interval{" +
					"start=" + start +
					", end=" + end +
					'}';
		}
	}
}
