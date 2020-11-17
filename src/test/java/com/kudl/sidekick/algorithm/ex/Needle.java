package com.kudl.sidekick.algorithm.ex;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Needle {
	public static int count(String needle, InputStream haystack) throws Exception {
		List<String> strings = Arrays.asList(new String(haystack.readAllBytes()).split("\n"));
		return Math.toIntExact(strings.stream()
				.filter(string -> string.contains(needle))
				.count());
	}

	public static void main(String[] args) throws Exception {
		String inMessage = "Hello, there!\nHow are you today?\nYes, you over there.";

		try(InputStream inStream = new ByteArrayInputStream(inMessage.getBytes())) {
			System.out.println(Needle.count("there", inStream));
		}
	}
}