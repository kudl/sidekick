package com.example.sidekick.rxjava;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Ex04 {
	public static void main(String[] args) {
		Flowable
			.just(1,2,3)
			.subscribe(new Subscriber<Integer>() {
				@Override
				public void onSubscribe(Subscription subscription) {
					System.out.println("onSubscribe START");
					subscription.request(Long.MAX_VALUE);
					System.out.println("onSubscribe END");
				}

				@Override
				public void onNext(Integer data) {
					System.out.println(data);
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}

				@Override
				public void onComplete() {
					System.out.println("Complete");
				}
			});
	}
}
