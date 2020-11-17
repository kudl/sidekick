package com.kudl.sidekick.rxjava;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Ex07 {

	public static void main(String[] args) {
		Completable completable = Completable.create(emitter -> {
			emitter.onComplete();
		});
		
		completable
			.subscribeOn(Schedulers.computation())
			.subscribe(new CompletableObserver() {
				@Override
				public void onSubscribe(Disposable d) {
					
				}

				@Override
				public void onComplete() {
					System.out.println("Complete");
				}

				@Override
				public void onError(Throwable e) {
					e.printStackTrace();
				}
			});
	}
}
