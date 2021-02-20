package com.kudl.sidekick.pattern.observer;

public class App {
	public static void main(final String[] args) {
		// Subject == Publisher == Event
		// Observer == Subscriber == Listener

		final Subject fashionStores = new StoreSubject();
		final Observer customer1 = new PassiveObserver();
		final Observer customer2 = new ShopaholicObserver();
		final Observer customer3 = new ShopaholicObserver();

		fashionStores.addObserver(customer1);
		fashionStores.addObserver(customer2);

		fashionStores.notifyObservers("hello");

		fashionStores.removeObserver(customer1);

		fashionStores.addObserver(customer3);

		fashionStores.notifyObservers("world");
	}
}
