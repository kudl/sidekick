package com.kudl.sidekick.pattern.visitor.v1;

public abstract class Element {

	public String uuid;

	public Element(final String uuid) {
		this.uuid = uuid;
	}

	public abstract void accept(Visitor v);
}
