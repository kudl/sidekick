package com.kudl.sidekick.ddd.domain;

import java.util.Objects;

public class Hide {

	private final Boolean value;

	private Hide(final Boolean value) {
		this.value = value;
	}

	public static Hide of(final Boolean value) {
		return new Hide(value);
	}

	public Boolean getValue() {
		return value;
	}

	public Boolean toBoolean() {
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
		final Hide hide = (Hide) o;
		return Objects.equals(value, hide.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return value ? "TRUE" : "FALSE";
	}
}
