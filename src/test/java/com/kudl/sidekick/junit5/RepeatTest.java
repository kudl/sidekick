package com.kudl.sidekick.junit5;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

class RepeatTest {

	@RepeatedTest(value = 5, name = "repeatTest : {currentRepetition}")
	void repeatTest(final RepetitionInfo repetitionInfo) {
		System.out.println("repeat_test : " + repetitionInfo.getCurrentRepetition()
				+ "/" + repetitionInfo.getTotalRepetitions());
	}
}
