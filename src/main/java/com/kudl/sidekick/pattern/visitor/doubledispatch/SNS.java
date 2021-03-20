package com.kudl.sidekick.pattern.visitor.doubledispatch;

public interface SNS {
	void post(Text post);

	void post(Picture post);
}
