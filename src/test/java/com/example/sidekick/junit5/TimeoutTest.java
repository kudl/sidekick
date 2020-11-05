package com.example.sidekick.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@SpringBootTest
public class TimeoutTest {

	@Test
	void timeoutNotExceeded() {
		assertTimeout(ofMinutes(2), () -> Thread.sleep(10));
	}

	@Test
	@Disabled
	void timeoutExceeded() {
		assertTimeout(ofMillis(10), () -> Thread.sleep(100));
	}
}
