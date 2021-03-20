package com.kudl.sidekick.pattern.visitor.v1;

public class XmlElement extends Element {

	public XmlElement(final String uuid) {
		super(uuid);
	}

	@Override
	public void accept(final Visitor v) {
		v.visit(this);
	}
}
