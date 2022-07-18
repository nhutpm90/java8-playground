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

class PancakeSorting {
	static void printArr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " - ");
		}
	}
	
	static void flip_array(int my_arr[], int i) {
		int temp, beg = 0;
		while (beg < i) {
			temp = my_arr[beg];
			my_arr[beg] = my_arr[i];
			my_arr[i] = temp;
			beg++;
			i--;
		}
	}

	static int find_index(int my_arr[], int n) {
		int max_ele, i;
		for (max_ele = 0, i = 0; i < n; ++i)
			if (my_arr[i] > my_arr[max_ele])
				max_ele = i;
		System.out.println("findIndex:: n:: " + n + " - maxElementIndex:: " + max_ele);
		System.out.println("arr");
		printArr(my_arr);
		return max_ele;
	}

	static int pancake_sort(int my_arr[], int n) {
		for (int curr_size = n; curr_size > 1; --curr_size) {
			int max_ele = find_index(my_arr, curr_size);
			if(curr_size == 3) {
				System.out.println();
			}
			if (max_ele != curr_size - 1) {
				flip_array(my_arr, max_ele);
				flip_array(my_arr, curr_size - 1);
			}
		}
		return 0;
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
	
	@Test
	void _02() throws InterruptedException {
		int my_arr[] = { 67, 43, 89, 11, 23, 0, 98, 102, 4 };
		int arr_len = my_arr.length;
		PancakeSorting.pancake_sort(my_arr, arr_len);
		System.out.println("The sorted array is : ");
		for (int i = 0; i < arr_len; i++)
			System.out.print(my_arr[i] + " ");
		System.out.println("");

	}
}
