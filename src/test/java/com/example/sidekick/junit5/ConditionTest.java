package com.example.sidekick.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.junit.jupiter.api.condition.OS.*;

@SpringBootTest
public class ConditionTest {

	@Test
	@EnabledOnOs({MAC, LINUX})
	public void enable_Mac_Linux() {
		System.out.println("Mac and Linux");
	}

	@Test
	@DisabledOnOs({WINDOWS, MAC})
	public void disable_Windows_MAC() {
		System.out.println("Windows And Mac");
	}

	@Test
	@EnabledOnJre(JAVA_8)
	public void enable_Java8() {
		System.out.println("Java 8");
	}

	@Test
	@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
	void only64bit() {
	}

	@Test
	@DisabledIfSystemProperty(named = "test", matches = "true")
	void onlyTestProperty() {
	}

}
