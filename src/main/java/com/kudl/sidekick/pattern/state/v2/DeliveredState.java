package com.kudl.sidekick.pattern.state.v2;

public class DeliveredState implements BoxState {

	@Override
	public void next(final Box box) {
		box.setState(new ReceivedState());
	}

	@Override
	public void prev(final Box box) {
		box.setState(new OrderedState());
	}

	@Override
	public void printStatus() {
		System.out.println("Box delivered to post office, not received yet.");
	}

	@Override
	public String toString() {
		return "DeliveredState{}";
	}
}
