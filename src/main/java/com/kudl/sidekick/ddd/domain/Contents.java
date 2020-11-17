package com.kudl.sidekick.ddd.domain;

import com.google.common.base.Strings;

import static com.google.common.base.Preconditions.checkArgument;

public class Contents {

	private final String value;

	private Contents(String value) {
		this.value = value;
	}

	public static Contents of(String contents) {
		checkArgument(!Strings.isNullOrEmpty(contents));

		return new Contents(contents);
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
