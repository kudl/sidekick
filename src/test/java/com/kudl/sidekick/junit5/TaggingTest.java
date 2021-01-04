package com.kudl.sidekick.junit5;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TaggingTest {
	/**
	 * Intellij EditConfigurations > Type of Resources > Select Tags & Input custom
	 * OR
	 * maven-sure-plugins setting
	 */

	@Test
	@Tag(value = "custom")
	void do_run_custom_test() {
		System.out.println("custom run");
	}

	@Test
	@CustomTest
	void do_run_custom_test2() {
		System.out.println("custom run 2");
	}

	@Test
	@Tag(value = "custom2")
	void not_run_test() {
		System.out.println("slow run");
	}

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@Test
	@Tag(value = "custom")
	public @interface CustomTest {

	}
}
