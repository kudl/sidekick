package com.kudl.sidekick.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("시간 초과로 테스트가 실패한다.")
	void timeoutExceeded() {
		assertTimeout(ofMillis(10), () -> Thread.sleep(100));
	}
}
