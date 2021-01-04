package com.kudl.sidekick.junit5;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterTest {

	@ParameterizedTest
	@CsvSource({"1, 2", "3, 4"})
	void parameterTest(final int i, final int j) {
		System.out.println("ParameterTest ==> " + i + " :: " + j);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "b", "c"})
	void valueSourceTest(final String message) {
		System.out.println("valueSourceTest : " + message);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"a", "b", "c"})
	void nullAndEmptySourceTest(final String message) {
		System.out.println("nullAndEmptySourceTest : " + message);
	}

	@ParameterizedTest
	@ValueSource(ints = {10, 20, 30})
	void convertWithTest(@ConvertWith(ProductConverter.class) final Product product) {
		System.out.println("convertWithTest : " + product.getId());
	}

	@ParameterizedTest
	@CsvSource({"10, coffee", "20, board"})
	void multipleParameterTest(final Integer id, final String name) {
		final Product product = new Product(id, name);
		System.out.println("multipleParameterTest : " + product);
	}

	@ParameterizedTest
	@CsvSource({"10, coffee", "20, board"})
	void aggregatorTest(@AggregateWith(ProductAggregator.class) final Product product) {
		System.out.println("multipleParameterTest : " + product);
	}

	static class ProductConverter extends SimpleArgumentConverter {
		@Override
		protected Object convert(final Object source, final Class<?> targetType) throws ArgumentConversionException {
			assertEquals(Product.class, targetType, "Can only convert to Product");
			return new Product(Integer.parseInt(source.toString()));
		}
	}

	/**
	 * The aggregator must be a public class or a static class.
	 */
	static class ProductAggregator implements ArgumentsAggregator {
		@Override
		public Object aggregateArguments(final ArgumentsAccessor accessor, final ParameterContext context) throws ArgumentsAggregationException {
			return new Product(accessor.getInteger(0), accessor.getString(1));
		}
	}

	public static class Product {
		private final int id;
		private String name;

		public Product(final int id) {
			this.id = id;
		}

		public Product(final int id, final String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "Product{" +
					"id=" + id +
					", name='" + name + '\'' +
					'}';
		}
	}
}
