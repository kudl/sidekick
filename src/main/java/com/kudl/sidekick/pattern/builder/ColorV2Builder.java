package com.kudl.sidekick.pattern.builder;

public final class ColorV2Builder {
	private String name;
	private String url;

	private ColorV2Builder() {
	}

	public static ColorV2Builder aColorV2() {
		return new ColorV2Builder();
	}

	public ColorV2Builder withName(final String name) {
		this.name = name;
		return this;
	}

	public ColorV2Builder withUrl(final String url) {
		this.url = url;
		return this;
	}

	public ColorV2 build() {
		return new ColorV2(name, url);
	}
}
