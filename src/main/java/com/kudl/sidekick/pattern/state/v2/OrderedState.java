package com.kudl.sidekick.pattern.state.v2;

public class OrderedState implements BoxState {

	@Override
	public void next(final Box box) {
		box.setState(new DeliveredState());
	}

	@Override
	public void prev(final Box box) {
		System.out.println("The box is in it's root state.");
	}

	@Override
	public void printStatus() {
		System.out.println("Box ordered, not delivered to the office yet.");
	}

	@Override
	public String toString() {
		return "OrderedState{}";
	}
}
