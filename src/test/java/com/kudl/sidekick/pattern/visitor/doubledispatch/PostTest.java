package com.kudl.sidekick.pattern.visitor.doubledispatch;

import org.junit.jupiter.api.Test;

import java.util.List;

class PostTest {

	@Test
	public void doRunPost() {
		final List<Post> posts = List.of(new Text(), new Picture());
		final List<SNS> snsGroup = List.of(new FaceBook(), new Twitter());
		posts.forEach(post -> snsGroup.forEach(sns -> post.postOn(sns)));
	}
}
