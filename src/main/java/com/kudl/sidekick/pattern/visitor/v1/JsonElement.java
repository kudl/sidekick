package com.kudl.sidekick.pattern.visitor.v1;

public class JsonElement extends Element {

	public JsonElement(final String uuid) {
		super(uuid);
	}

	@Override
	public void accept(final Visitor v) {
		v.visit(this);
	}
}
