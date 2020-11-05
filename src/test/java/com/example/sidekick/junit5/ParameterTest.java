package com.example.sidekick.junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParameterTest {

	@ParameterizedTest
	@CsvSource({"1, 2", "3, 4"})
	void parameterTest(int i, int j) {
		System.out.println("ParameterTest ==> " + i + " :: " + j);
	}
}
