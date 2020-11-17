package com.kudl.sidekick.ddd.domain;

public class Hide {

	private final Boolean value;

	private Hide(Boolean value) {
		this.value = value;
	}

	public static Hide of(Boolean value) {
		return new Hide(value);
	}

	public Boolean getValue() {
		return value;
	}

	public Boolean toBoolean() {
		return value;
	}

	@Override
	public String toString() {
		return value ? "TRUE" : "FALSE";
	}
}
