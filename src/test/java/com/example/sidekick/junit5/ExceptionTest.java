package com.example.sidekick.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ExceptionTest {

	@Test
	@DisplayName("NullPoint Exception")
	void nullPointException() {
		Throwable e = assertThrows(NullPointerException.class, () -> {
			throw new NullPointerException("Object Null Error");
		});
		assertEquals("Object Null Error", e.getMessage());
	}
}
