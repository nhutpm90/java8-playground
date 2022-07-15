package com.example.java8.thread.demo02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class Processor {

	private int count = 0;

	private synchronized void increment() {
		count++;
	}

	public void doWork() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		t1.start();
		t2.start();

		// wait for thread to complete
		t1.join();
		t2.join();

		System.out.println("count:: " + count);
	}
}

class Processor1 {
	private List<Integer> list = null;

	public Processor1() {
		list = Collections.synchronizedList(new ArrayList<>());
//		list = new ArrayList<>();
	}

	public void increment() {
		list.add(list.size() + 1);
	}

	public List<Integer> getList() {
		return this.list;
	}
}

@SpringBootTest
class JavaThreadPractices_ResultTests {

	@Test
	void contextLoads() {
	}

	@Test
	void _01() throws InterruptedException {
		new Processor().doWork();
	}

	private Thread createThread(Processor1 processor) {
		Thread t = new Thread(() -> {
			try {
				for (int i = 0; i < 1000; i++) {
					processor.increment();
					Thread.sleep(1);
				}
			} catch (InterruptedException e) {
			}
		});
		t.start();
		return t;
	}

	@Test
	void _02() throws InterruptedException {

		System.out.println("starting...");
		long start = System.currentTimeMillis();
		Processor1 processor1 = new Processor1();

		System.out.println("start thread 1");
		Thread t1 = createThread(processor1);
		
		System.out.println("start thread 2");
		Thread t2 = createThread(processor1);
		
		System.out.println("start thread 3");
		Thread t3 = createThread(processor1);

		t1.join();
		t2.join();
		t3.join();

		long end = System.currentTimeMillis();

		System.out.println("Time take:: " + (end - start));
		System.out.println("List:: " + processor1.getList().size());
		System.out.println("ended");
	}
}
