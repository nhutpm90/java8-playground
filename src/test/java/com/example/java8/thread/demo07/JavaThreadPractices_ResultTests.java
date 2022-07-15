package com.example.java8.thread.demo07;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class Processor {
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	public void producer() throws InterruptedException {
		Random random = new Random();
		while (true) {
			// loop indefinitely
			// if queue is full (10) waits
			queue.put(random.nextInt(100));
		}
	}

	public void consumer() throws InterruptedException {
		Random random = new Random();
		while (true) {
			Thread.sleep(100);
			if (random.nextInt(10) == 0) {
				Integer value = queue.take();// if queue is empty waits
				System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
			}
		}
	}
	
	public void main() throws InterruptedException {
		Processor processor = new Processor();
		Thread t1 = new Thread(() -> {
			try { processor.producer(); } catch (InterruptedException e) { }
		});

		Thread t2 = new Thread(() -> {
			try { processor.consumer(); } catch (InterruptedException e) { }
		});

		t1.start();
		t2.start();

//		t1.join();
//		t2.join();

		Thread.sleep(30000);
		System.exit(0);
	
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
