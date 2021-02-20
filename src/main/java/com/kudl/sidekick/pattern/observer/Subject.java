package com.kudl.sidekick.pattern.observer;

public interface Subject {
	// Subject == Publisher == Event
	void addObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObservers(String message);
}
