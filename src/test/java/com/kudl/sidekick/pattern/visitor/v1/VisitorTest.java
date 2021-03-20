package com.kudl.sidekick.pattern.visitor.v1;

import java.util.UUID;

public class VisitorTest {

	public static void main(final String[] args) {

		final Visitor v = new ElementVisitor();

		final Document d = new Document(generateUuid());
		d.elements.add(new JsonElement(generateUuid()));
		d.elements.add(new JsonElement(generateUuid()));
		d.elements.add(new XmlElement(generateUuid()));

		d.accept(v);
	}

	private static String generateUuid() {
		return UUID.randomUUID()
				.toString();
	}
}
