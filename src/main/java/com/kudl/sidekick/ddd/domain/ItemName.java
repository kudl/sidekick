package com.kudl.sidekick.ddd.domain;

import com.google.common.base.Strings;

import static com.google.common.base.Preconditions.checkArgument;

public class ItemName {

	private final String value;

	private ItemName(String value) {
		this.value = value;
	}

	public static ItemName of(String name) {
		checkArgument(!Strings.isNullOrEmpty(name));

		return new ItemName(name);
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
