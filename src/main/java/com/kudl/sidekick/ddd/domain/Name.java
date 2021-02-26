package com.kudl.sidekick.ddd.domain;

import com.google.common.base.Strings;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

public class Name {

	private final String value;

	private Name(final String value) {
		this.value = value;
	}

	public static Name of(final String name) {
		checkArgument(!Strings.isNullOrEmpty(name));

		return new Name(name);
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
		final Name name = (Name) o;
		return Objects.equals(value, name.value);
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
