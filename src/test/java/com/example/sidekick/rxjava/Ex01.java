package com.example.sidekick.rxjava;

import io.reactivex.Flowable;

public class Ex01 {

	public static void main(String[] args) {
		Flowable<String> flowable = Flowable.just("hello", "world");

		flowable.subscribe(data -> System.out.println(data));
	}
}
