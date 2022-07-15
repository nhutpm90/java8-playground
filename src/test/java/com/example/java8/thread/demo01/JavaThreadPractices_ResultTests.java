package com.example.java8.thread.demo01;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class Processor extends Thread {

	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

@SpringBootTest
class JavaThreadPractices_ResultTests {

	@Test
	void contextLoads() {
	}

	@Test
	void _01() throws InterruptedException {
		Processor proc = new Processor();
		proc.start();

		System.out.println("press enter to stop");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		proc.shutdown();
		scanner.close();
	}
}
