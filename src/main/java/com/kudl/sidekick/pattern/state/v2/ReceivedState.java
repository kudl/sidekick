package com.kudl.sidekick.pattern.state.v2;

public class ReceivedState implements BoxState {

	@Override
	public void next(final Box box) {
		System.out.println("This box is already received by a client.");
	}

	@Override
	public void prev(final Box box) {
		box.setState(new DeliveredState());
	}

	@Override
	public void printStatus() {
		System.out.println("Box was received by client.");
	}

	@Override
	public String toString() {
		return "ReceivedState{}";
	}
}
