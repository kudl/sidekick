package com.kudl.sidekick.pattern.visitor.doubledispatch;

public class Twitter implements SNS {
	@Override
	public void post(final Text post) {
		System.out.println("Text Twitter");
	}

	@Override
	public void post(final Picture post) {
		System.out.println("Picture Twitter");
	}
}
