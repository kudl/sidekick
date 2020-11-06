package com.example.sidekick.algorithm.etc;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Immigration {
	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};
		long result = 28;

		assertThat(new Immigration().solution(n, times)).isEqualTo(result);
	}

	private long solution(int n, int[] times) {
		Arrays.sort(times);

		long min = 1;
		long max = (long) times[times.length - 1] * n;
		long mid = 0;
		long sum;
		long answer = max;

		while (min <= max) {
			sum = 0;
			mid = (min + max) / 2;
			for (int time : times) {
				sum += mid / time;
			}
			if (sum >= n) {
				if (mid < answer) {
					answer = mid;
				}
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		return answer;
	}
}
