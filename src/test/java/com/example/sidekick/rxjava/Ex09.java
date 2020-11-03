package com.example.sidekick.rxjava;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Ex09 {
	public static void main(String[] args) {
		Flowable<Integer> flowable = Flowable.<Integer>create(emitter -> {
			System.out.println("START");

			for (int i = 0; i < 3; i++) {
				if(i == 2) {
					throw new Exception("On Error");
				}

				emitter.onNext(i);
			}

			emitter.onComplete();

			System.out.println("emitter Complete");
		}, BackpressureStrategy.BUFFER)
				.doOnSubscribe(subscription -> System.out.println("doOnSubscribe"))
				.retry(2);

		flowable.subscribe(new Subscriber<Integer>() {
			@Override
			public void onSubscribe(Subscription subscription) {
				System.out.println("onSubscribe");
				subscription.request(Long.MAX_VALUE);
			}

			@Override
			public void onNext(Integer data) {
				System.out.println("data :: " + data);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("Error :: " + t);
			}

			@Override
			public void onComplete() {
				System.out.println("Complete");
			}
		});
	}
}
