package com.kudl.sidekick.rxjava;

import io.reactivex.Flowable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Ex08 {
	public static void main(String[] args) throws InterruptedException {
		Ex08 ex = new Ex08();

		System.out.println("==== flatMapSample ====");
		ex.flatMapSample();

		System.out.println("==== concatMapSample ====");
		ex.concatMapSample();
	}

	public void flatMapSample() throws InterruptedException {
		Flowable<String> flowable = Flowable.just("A","B","C")
				.flatMap(data -> {
					return Flowable.just(data).delay(1000L, TimeUnit.MILLISECONDS);
				});

		flowable.subscribe(data -> {
			String threadName = Thread.currentThread().getName();
			String time = LocalTime.now().format(DateTimeFormatter.ofPattern("ss.SSS"));
			System.out.println(threadName + " ==> " + data + " :: " + time);
		});

		Thread.sleep(4000L);
	}

	public void concatMapSample() throws InterruptedException {
		Flowable<String> flowable = Flowable.just("A","B","C")
				.concatMap(data -> {
					return Flowable.just(data).delay(1000L, TimeUnit.MILLISECONDS);
				});

		flowable.subscribe(data -> {
			String threadName = Thread.currentThread().getName();
			String time = LocalTime.now().format(DateTimeFormatter.ofPattern("ss.SSS"));
			System.out.println(threadName + " ==> " + data + " :: " + time);
		});

		Thread.sleep(4000L);
	}
}
