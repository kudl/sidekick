package com.kudl.sidekick.junit5;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class LifecyclePerClassTest {

	/**
	 * The basic strategy for junit5 is to create a test class for each @test method.
	 * By setting the Lifecycle.PER_CLASS option of the @TestInstance annotation,
	 * a test object is created and shared for use.
	 * It is not a good idea to have a test order dependency,
	 * but the @TestMethodOrder annotation allows you to specify the test order.
	 */

	private int index = 0;

	@Order(2)
	@Test
	public void run1() {
		index++;

		System.out.println(this);
		System.out.println(index);

		assertThat(index).isEqualTo(2);
	}

	@Order(1)
	@Test
	public void run2() {
		index++;

		System.out.println(this);
		System.out.println(index);

		assertThat(index).isEqualTo(1);
	}
}
