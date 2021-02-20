package com.kudl.sidekick.pattern.observer;

public class PassiveObserver implements Observer {
	@Override
	public void update(final String message) {
		System.out.println("PassiveObserver " + message);
	}
}
