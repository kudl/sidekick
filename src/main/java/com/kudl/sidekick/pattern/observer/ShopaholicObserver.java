package com.kudl.sidekick.pattern.observer;

public class ShopaholicObserver implements Observer {
	@Override
	public void update(final String message) {
		System.out.println("ShopaholicObserver " + message);
	}
}
