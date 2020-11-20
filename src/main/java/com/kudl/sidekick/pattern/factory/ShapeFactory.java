package com.kudl.sidekick.pattern.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ShapeFactory {

	private static final Map<ShapeType, Supplier<? extends Shape>> SHAPE_MAP = new HashMap<>();

	static {
		SHAPE_MAP.put(ShapeType.CIRCLE, Circle::new);
		SHAPE_MAP.put(ShapeType.RECTANGLE, Rectangle::new);
	}

	private ShapeFactory() {
	}

	public static Shape getInstance(final ShapeType shapeType) {
		return SHAPE_MAP.get(shapeType).get();
	}
}
