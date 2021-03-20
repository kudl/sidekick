package com.kudl.sidekick.pattern.visitor.v1;

import java.util.ArrayList;
import java.util.List;

public class Document extends Element {

	List<Element> elements = new ArrayList<>();

	public Document(final String uuid) {
		super(uuid);
	}

	@Override
	public void accept(final Visitor v) {
		for (final Element e : this.elements) {
			e.accept(v);
		}
	}
}
