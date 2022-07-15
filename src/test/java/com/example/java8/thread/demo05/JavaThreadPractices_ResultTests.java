package com.example.java8.thread.demo05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class Processor implements Runnable {

	private int id;

	public Processor(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("+ starting:: " + id);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("- completed:: " + id);
	}
}

@SpringBootTest
class JavaThreadPractices_ResultTests {

	@Test
	void contextLoads() {
	}

	@Test
	void _01() throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 1; i <= 10; i++) {
			executor.submit(new Processor(i));
		}

		executor.shutdown();

//		System.out.println("all tasked submitted");

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("all tasked completed");

	}
}
