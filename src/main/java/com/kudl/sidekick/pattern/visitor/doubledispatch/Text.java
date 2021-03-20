package com.kudl.sidekick.pattern.visitor.doubledispatch;

public class Text implements Post {
	@Override
	public void postOn(final SNS sns) {
		sns.post(this);
	}
}
