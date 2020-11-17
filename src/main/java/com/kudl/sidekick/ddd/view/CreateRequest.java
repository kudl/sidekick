package com.kudl.sidekick.ddd.view;

public class CreateRequest {
	private String name;
	private String contents;

	private CreateRequest() {
	}

	public CreateRequest(String name, String contents) {
		this.name = name;
		this.contents = contents;
	}

	public String getName() {
		return name;
	}

	public String getContents() {
		return contents;
	}
}
