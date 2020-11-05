package com.example.sidekick.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AssertAllTest {

	@Test
	void assertAllTest() {
		String hello = "Hello";
		String world = "World";
		assertAll("headingV1",
				() -> assertEquals("Hello", hello),
				() -> assertEquals("Hello", hello),
				() -> {
					assertAll("headingV2",
							() -> assertEquals("World", world),
							() -> assertEquals("World", world)
					);
		});
	}
}
