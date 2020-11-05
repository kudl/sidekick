package com.example.sidekick.junit5;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NestedTest {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("Foo beforeAll");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("Foo afterAll");
	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("Foo beforeEach");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("Foo afterEach");
	}

	@Test
	public void test() {
		System.out.println("Foo test");
	}

	@Nested
	public class Bar {
		@BeforeEach
		public void beforeEach() {
			System.out.println("Bar beforeEach");
		}

		@AfterEach
		public void afterEach() {
			System.out.println("Bar afterEach");
		}

		@Test
		public void test() {
			System.out.println("Bar Test");
		}
	}
}
