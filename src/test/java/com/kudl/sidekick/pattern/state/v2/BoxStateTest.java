package com.kudl.sidekick.pattern.state.v2;

import org.junit.jupiter.api.Test;

class BoxStateTest {

	@Test
	public void boxStateChangeTest() {
		final Box box = new Box();
		box.printStatus();

		box.nextState();
		box.printStatus();

		box.nextState();
		box.printStatus();

		box.nextState();
		box.printStatus();
	}
}
