package com.kudl.sidekick.pattern.state.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeaveRequestStateTest {

	@Test
	public void leaveRequestStateTest() {
		LeaveRequestState state = LeaveRequestState.SUBMITTED;

		state = state.nextState();
		assertEquals(LeaveRequestState.ESCALATED, state);

		state = state.nextState();
		assertEquals(LeaveRequestState.APPROVED, state);

		state = state.nextState();
		assertEquals(LeaveRequestState.APPROVED, state);
	}
}
