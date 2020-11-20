package com.kudl.sidekick.pattern.factory;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ShapeFactoryTest {

	@Test
	public void shapeTest() {
		final Shape circle = ShapeFactory.getInstance(ShapeType.CIRCLE);
		final Shape rectangle = ShapeFactory.getInstance(ShapeType.RECTANGLE);

		assertAll("ShapeFactoryTest",
				() -> assertThat("Circle Draw()").isEqualTo(circle.draw()),
				() -> assertThat("Rectangle Draw()").isEqualTo(rectangle.draw())
		);
	}
}