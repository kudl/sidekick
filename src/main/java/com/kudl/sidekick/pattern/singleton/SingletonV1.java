package com.kudl.sidekick.pattern.singleton;

/**
 * Eagerly singleton, thread safety
 */
public class SingletonV1 {

	private SingletonV1() {
	}

	private static final SingletonV1 instance = new SingletonV1();

	public static SingletonV1 getInstance() {
		return instance;
	}
}
