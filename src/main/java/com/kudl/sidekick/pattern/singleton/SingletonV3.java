package com.kudl.sidekick.pattern.singleton;

/**
 * Enum based singleton implementation. Thread safety
 */
public enum SingletonV3 {
	INSTANCE;

	@Override
	public String toString() {
		return getDeclaringClass().getCanonicalName() + "@" + hashCode();
	}
}
