package com.example.java8.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class RunnerByThread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("hello" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class RunnerByRunnable implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("hello" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

@SpringBootTest
class JavaThreadPractices_ResultTests {

	@Test
	void contextLoads() {
	}

	private void breakLine(String header) {
		System.out.println("\n-----" + header);
	}

	@Test
	void _01() throws InterruptedException {
		breakLine("------01 - create thread using thread");
		RunnerByThread t1 = new RunnerByThread();
		t1.start();
		t1.join();
	}

	@Test
	void _02() throws InterruptedException {
		breakLine("------01 - create thread using runnable");
		Thread t1 = new Thread(new RunnerByRunnable());
		t1.start();
		t1.join();
	}

	@Test
	void _03() throws InterruptedException {
		breakLine("------01 - create thread using anonymous function");
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("hello" + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t1.join();
	}
}
