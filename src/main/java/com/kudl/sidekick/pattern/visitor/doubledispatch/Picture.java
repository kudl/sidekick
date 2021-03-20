package com.kudl.sidekick.pattern.visitor.doubledispatch;

public class Picture implements Post {
	@Override
	public void postOn(final SNS sns) {
		sns.post(this);
	}
}
