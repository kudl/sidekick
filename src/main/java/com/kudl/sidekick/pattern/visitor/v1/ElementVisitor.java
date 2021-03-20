package com.kudl.sidekick.pattern.visitor.v1;

public class ElementVisitor implements Visitor {
	@Override
	public void visit(final XmlElement xmlElement) {
		System.out.println("processing xml element with uuid: " + xmlElement.uuid);
	}

	@Override
	public void visit(final JsonElement jsonElement) {
		System.out.println("processing json element with uuid: " + jsonElement.uuid);
	}
}
