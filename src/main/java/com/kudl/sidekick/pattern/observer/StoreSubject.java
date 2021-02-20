package com.kudl.sidekick.pattern.observer;

import java.util.HashSet;
import java.util.Set;

public class StoreSubject implements Subject {

	private final Set<Observer> customers = new HashSet<>();

	@Override
	public void addObserver(final Observer customer) {
		customers.add(customer);
	}

	@Override
	public void removeObserver(final Observer customer) {
		customers.remove(customer);
	}

	@Override
	public void notifyObservers(final String message) {
		customers.forEach(c -> c.update(message));
	}
}
