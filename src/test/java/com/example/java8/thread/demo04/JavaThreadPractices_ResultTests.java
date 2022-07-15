package com.example.java8.thread.demo04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class Processor {

	private Random random = new Random();

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	public void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}

	public void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void main() {
		System.out.println("starting...");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();

		System.out.println("Time take:: " + (end - start));
		System.out.println("List1:: " + list1.size() + " - List2:: " + list2.size());
	}
}

@SpringBootTest
class JavaThreadPractices_ResultTests {

	@Test
	void contextLoads() {
	}

	@Test
	void _01() throws InterruptedException {
		new Processor().main();
	}
}
