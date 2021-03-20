package com.kudl.sidekick.pattern.visitor.v1;

public interface Visitor {

	void visit(XmlElement xmlElement);

	void visit(JsonElement jsonElement);
}
