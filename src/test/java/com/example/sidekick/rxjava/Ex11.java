package com.example.sidekick.rxjava;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

public class Ex11 {
	public static void main(String[] args) throws InterruptedException {
		Flowable<Long> flowable = Flowable.interval(10L, TimeUnit.MILLISECONDS)
				.doOnNext(value -> System.out.println("emit :: " + value));

		flowable
			.observeOn(Schedulers.computation())
			.subscribe(new Subscriber<Long>() {
				@Override
				public void onSubscribe(Subscription subscription) {
					subscription.request(Long.MAX_VALUE);
				}

				@Override
				public void onNext(Long aLong) {
					try {
						System.out.println("waiting....");
						Thread.sleep(1000L);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				@Override
				public void onError(Throwable t) {
					System.out.println("onError :: " + t);
				}

				@Override
				public void onComplete() {
					System.out.println("Complete");
				}
			});

		Thread.sleep(5000L);
	}
}
