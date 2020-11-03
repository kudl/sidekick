package com.example.sidekick.rxjava;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;

public class Ex10 {
	public static void main(String[] args) {
		Flowable.just(1,3,5,0,2,4)
			.map(data -> 100 / data)
			.onErrorReturnItem(0)
			.subscribe(new DisposableSubscriber<Integer>() {
				@Override
				public void onNext(Integer data) {
					System.out.println("onNext :: " + data);
				}

				@Override
				public void onError(Throwable t) {
					System.out.println("onError :: " + t);
				}

				@Override
				public void onComplete() {
					System.out.println("onComplete");
				}
			});
	}
}
