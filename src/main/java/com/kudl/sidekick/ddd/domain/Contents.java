package com.kudl.sidekick.ddd.domain;

import com.google.common.base.Strings;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

public class Contents {

	private final String value;

	private Contents(final String value) {
		this.value = value;
	}

	public static Contents of(final String contents) {
		checkArgument(!Strings.isNullOrEmpty(contents));

		return new Contents(contents);
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Contents contents = (Contents) o;
		return Objects.equals(value, contents.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return value;
	}
}
