package com.kudl.sidekick.pattern.builder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuilderTest {

	public static final String NAME = "red";
	public static final String URL = "/red.png";

	@Test
	public void colorV1Test() {
		final ColorV1 colorV1 = ColorV1.builder()
				.withName(NAME)
				.withImageURL(URL)
				.build();

		assertThat(colorV1.getName()).isEqualTo(NAME);
	}

	@Test
	public void colorV2Test() {
		final ColorV2 colorV2 = ColorV2Builder.aColorV2()
				.withName(NAME)
				.withUrl(URL)
				.build();

		assertThat(colorV2.getName()).isEqualTo(NAME);
	}
}
