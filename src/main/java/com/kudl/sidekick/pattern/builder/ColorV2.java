package com.kudl.sidekick.pattern.builder;

public class ColorV2 {
	private final String name;
	private final String url;

	public ColorV2(final String name, final String url) {
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "ColorV2{" +
				"name='" + name + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}
