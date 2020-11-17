package com.kudl.sidekick.rxjava;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Ex02 {

	public static void main(String[] args) throws InterruptedException {
		Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
			@Override
			public void subscribe(FlowableEmitter<String> emitter) throws Exception {
				String[] datas = {"Hello, World!", "Good, RxJava"};

				for (String data : datas) {
					if (emitter.isCancelled()) {
						return;
					}

					emitter.onNext(data);
				}

				emitter.onComplete();
			}
		}, BackpressureStrategy.BUFFER);

		flowable
			.observeOn(Schedulers.computation())
			.subscribe(new Subscriber<String>() {

				private Subscription subscription;

				@Override
				public void onSubscribe(Subscription subscription) {
					this.subscription = subscription;
					this.subscription.request(1L);
				}

				@Override
				public void onNext(String data) {
					String threadName = Thread.currentThread().getName();
					System.out.println(threadName + " : " + data);
					this.subscription.request(1L);
				}

				@Override
				public void onComplete() {
					String threadName = Thread.currentThread().getName();
					System.out.println(threadName + " : Complete");
				}

				@Override
				public void onError(Throwable error) {
					error.printStackTrace();
				}
			});

		Thread.sleep(500L);
	}
}
