package com.kudl.sidekick.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Ex03 {
	public static void main(String[] args) throws InterruptedException {
		Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
			@Override
			public void subscribe(ObservableEmitter<String> emitter) throws Exception {
				String[] datas = {"Hello", "World"};

				for (String data : datas) {
					if(emitter.isDisposed()) {
						return;
					}

					emitter.onNext(data);
				}

				emitter.onComplete();
			}
		});

		observable
			.observeOn(Schedulers.computation())
			.subscribe(new Observer<String>() {
				@Override
				public void onSubscribe(Disposable d) {

				}

				@Override
				public void onNext(String data) {
					System.out.println(Thread.currentThread().getName() + " : " + data);
				}

				@Override
				public void onError(Throwable e) {
					e.printStackTrace();
				}

				@Override
				public void onComplete() {
					System.out.println(Thread.currentThread().getName() + " : Complete");
				}
			});

		Thread.sleep(500L);
	}
}
