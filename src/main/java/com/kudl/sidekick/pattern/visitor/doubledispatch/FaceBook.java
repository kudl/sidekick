package com.kudl.sidekick.pattern.visitor.doubledispatch;

public class FaceBook implements SNS {
	@Override
	public void post(final Text post) {
		System.out.println("Text facebook");
	}

	@Override
	public void post(final Picture post) {
		System.out.println("Picture facebook");
	}
}
