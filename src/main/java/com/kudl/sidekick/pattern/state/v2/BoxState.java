package com.kudl.sidekick.pattern.state.v2;

public interface BoxState {

	void next(Box box);

	void prev(Box box);

	void printStatus();
}
