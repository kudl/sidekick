package com.kudl.sidekick.ddd.domain;

import com.google.common.base.Strings;

import static com.google.common.base.Preconditions.checkArgument;

public class Name {

	private final String value;

	private Name(String value) {
		this.value = value;
	}

	public static Name of(String name) {
		checkArgument(!Strings.isNullOrEmpty(name));

		return new Name(name);
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
