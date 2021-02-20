package com.kudl.sidekick.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

	public static void main(final String[] args) {
		final String a1 = "a";
		final String a2 = "a";
		final String a3 = a1;
		final String a4 = new String("a");

		System.out.println(a1 == a2);
		System.out.println(a1 == a3);
		System.out.println(a1 == a4);

		System.out.println(a1.equals(a2));
		System.out.println(a1.equals(a3));
		System.out.println(a1.equals(a4));

		final Map<String, Integer> map22 = new HashMap<>();
		map22.put(a1, 1);
		map22.put(a2, 1);
		map22.put(a3, 1);
		map22.put(a4, 1);
		System.out.println(map22.size());

		System.out.println("=====222");
		final Person person1 = new Person(1);
		final Person person2 = new Person(1);
		final Person person3 = person1;

		System.out.println(person1 == person2);
		System.out.println(person1 == person3);
		System.out.println(person1.equals(person2));

		final Map<Person, Integer> map = new HashMap<>();
		map.put(person1, 1);
		map.put(person2, 1);
		map.put(person3, 1);

		System.out.println(map.size());

		System.out.println("======== set");
		final Set<Integer> at = new HashSet<>();
		at.add(1);
		at.add(1);
		System.out.println(at.size());

		System.out.println("=========333");

		final Map<Integer, Integer> map2 = new HashMap<>();
		map2.put(new Integer(12222), 1);
		map2.put(12222, 1);

		System.out.println(map2.size());

		final Integer c = 12222;
		final Integer c1 = new Integer(12222);
		final Integer c2 = 12222;
		System.out.println(c == c1);
		System.out.println(c == c2);
		System.out.println(c.equals(c1));
	}

	public static class Person {
		private int id;

		private Person() {

		}


		public Person(final int i) {
			this.id = id;
		}

//		@Override
//		public boolean equals(final Object o) {
//			if (this == o) {
//				return true;
//			}
//			if (o == null || getClass() != o.getClass()) {
//				return false;
//			}
//			final Person person = (Person) o;
//			return id == person.id;
//		}
//
//		@Override
//		public int hashCode() {
//			return Objects.hash(id);
//		}
	}
}
