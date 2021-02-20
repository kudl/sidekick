package com.kudl.sidekick.pattern.builder;

public class ColorV1 {
	private final String name;
	private final String url;

	public ColorV1(final ColorBuilder colorBuilder) {
		this.name = colorBuilder.name;
		this.url = colorBuilder.url;
	}

	public static ColorBuilder builder() {
		return new ColorBuilder();
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "ColorV1{" +
				"name='" + name + '\'' +
				", url='" + url + '\'' +
				'}';
	}

	public static class ColorBuilder {
		private String name;
		private String url;

		public ColorBuilder withName(final String name) {
			this.name = name;
			return this;
		}

		public ColorBuilder withImageURL(final String url) {
			this.url = url;
			return this;
		}

		public ColorV1 build() {
			return new ColorV1(this);
		}
	}
}
