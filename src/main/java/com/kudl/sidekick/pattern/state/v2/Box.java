package com.kudl.sidekick.pattern.state.v2;

public class Box {

	private BoxState state = new OrderedState();

	public BoxState getState() {
		return state;
	}

	public void setState(final BoxState state) {
		this.state = state;
	}

	public void previousState() {
		state.prev(this);
	}

	public void nextState() {
		state.next(this);
	}

	public void printStatus() {
		state.printStatus();
	}
}
