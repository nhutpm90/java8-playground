package com.example.java8.algo.sorting;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SortingPractices_01_ResultTests {

	private Integer[] copyOf;

	@Test
	void contextLoads() {
	}

	void printArr(Integer[] arr) {
		Arrays.stream(arr).forEach(item -> System.out.print(item + " "));
	}
	
	void swap(Integer[] arr, int i, int j) {
		Integer temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	@Test
	void _01() {
		// bubble sort
		Integer[] arr = new Integer[] { 6, 5, 3, 1, 8, 7, 2, 4 };
//		Integer[] arr = new Integer[] { 6, 5 };
		System.out.println("bubble sort");
		System.out.println("\ndata:: " + Arrays.deepToString(arr) + "\n- size:: " + arr.length);
		// begin
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
		// end
		Integer[] result = arr;
		Integer[] expectedResult = _01_result(Arrays.copyOf(arr, arr.length));
		System.out.println("\nresult:: " + Arrays.deepToString(result) 
						+ "\nexpected:: " + Arrays.deepToString(expectedResult));
	}
	
	Integer[] _01_result(Integer[] arr) {
		// 6, 5, 3, 1, 8, 7, 2, 4
		// loop 0 -> n -1
		// 		loop 0 -> n - 1 
		// (for every loop, we swap the highest to the right, so we only need to loop to n - i
		
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			System.out.println("\n***** begin loop:: from:: " + i + " --> " + (n - 1));
			System.out.print("- ");
			printArr(arr);
			System.out.println("\n");
			for (int j = 0; j < n - 1 - i; j++) {
				System.out.println(String.format("+ loop %s --> %s - comparing:: %s > %s --> %s", 
						j, n-1-i, arr[j], arr[j+1], arr[j] > arr[j+1]));
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					System.out.print("++ ");
					printArr(arr);
					System.out.println();
				} else {
					System.out.println("--> skip");
				}
			}
			System.out.println("*****end loop::");
		}
		return arr;
	}
	
	@Test
	void _02() {
		// selection sort
		Integer[] arr = new Integer[] { 6, 5, 3, 1, 8, 7, 2, 4 };
		System.out.println("selection sort");
		System.out.println("\ndata:: " + Arrays.deepToString(arr) + "\n- size:: " + arr.length);
		// begin
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			int minIndex = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
		// end
		Integer[] result = arr;
		Integer[] expectedResult = _02_result(Arrays.copyOf(arr, arr.length));
		System.out.println("\nresult:: " + Arrays.deepToString(result) 
						+ "\nexpected:: " + Arrays.deepToString(expectedResult));
	}
	
	Integer[] _02_result(Integer[] arr) {
		// 6, 5, 3, 1, 8, 7, 2, 4
		// loop i=0 -> n - 1
		// 		loop i+1 -> n
		// 			compare i with j
		//			then swap
		
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			System.out.println("\n***** begin loop:: from:: " + i + " --> " + (n - 1 -1));
			int minIndex = i;
			System.out.println("minIndex:: " + minIndex);
			for (int j = i + 1; j < n; j++) {
				System.out.println(String.format("\n+ loop %s --> %s - comparing:: %s < %s --> %s", 
						j, n-1, arr[j], arr[minIndex], arr[j] < arr[minIndex]));
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
					System.out.print("++ minIndex:: " + minIndex + " --> value::" + arr[minIndex]);
				} else {
					System.out.println("--> skip");
				}
			}
			if (minIndex != i) {
				swap(arr, i, minIndex);
			}
		}
		return arr;
	}

	@Test
	void _03() {
		// insertion sort
		Integer[] arr = new Integer[] { 4, 6, 7, 5, 3, 1, 8, 7, 2, 4 };
		System.out.println("insertion sort");
		System.out.println("\ndata:: " + Arrays.deepToString(arr) + "\n- size:: " + arr.length);
		// begin
		System.out.println("begin");
		int n = arr.length;
		// 4, 6, 7, 5, 3, 1, 8, 7, 2, 4
		for(int i=1; i<n; i++) {
			int valueToCompare = arr[i];
			int j=i-1;
			while(j>=0 && valueToCompare < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = valueToCompare;
		}
		System.out.println("end");
		// end
		Integer[] result = arr;
		Integer[] expectedResult = _03_result(Arrays.copyOf(arr, arr.length));
		System.out.println("\nresult:: " + Arrays.deepToString(result) 
						+ "\nexpected:: " + Arrays.deepToString(expectedResult));
	
	}
	
	Integer[] _03_result(Integer[] arr) {
		// sorted_side | array
		// 0 | i=1 -> n
		// in case currentValue < previousValue --> it can be moved to sorted_side
		
		int n = arr.length;
		for(int i=1; i<n; i++) {
			System.out.println("\n***** begin loop:: from:: " + i + " --> " + (n - 1));
			int curr = arr[i];
			int j=i-1;
			System.out.println("previous:: " + arr[j] + " - current:: " + curr);
			while(j >= 0 && arr[j] > curr) {
				arr[j+1] = arr[j];
				j--;
				System.out.print("++ ");
				printArr(arr);
				System.out.println();
			}
			arr[j+1] = curr;
		}
		return arr;
	}
	
	@Test
	void _04() {
		// pancake sort
//		Integer[] arr = new Integer[] { 4, 6, 7, 5, 3, 1, 8, 7, 2, 4 };
		Integer[] arr = new Integer[] { 3, 2, 4, 1 };
		System.out.println("pancake sort");
		System.out.println("\ndata:: " + Arrays.deepToString(arr) + "\n- size:: " + arr.length);
		// begin
		System.out.println("begin");
		System.out.println("end");
		// end
		Integer[] result = arr;
		Integer[] expectedResult = _04_result(Arrays.copyOf(arr, arr.length));
		System.out.println("\nresult:: " + Arrays.deepToString(result) 
						+ "\nexpected:: " + Arrays.deepToString(expectedResult));
	
	}
	
	Integer[] _04_result(Integer[] arr) {
		int n = arr.length;
//		System.out.println("maxIndex:: " + findMax(arr, arr.length));
		for(int currentSize=n; currentSize>0; currentSize--) {
			System.out.println("\n***** begin loop:: from:: " + currentSize + " --> " + 1);
			System.out.print("- ");
			printArr(arr);
			System.out.println("\n");
			
			int maxIndex = this.findMax(arr, currentSize);
			System.out.println("+ maxIndex:: " + maxIndex + " - endIndex:: " + (currentSize - 1));
			// in case maxValue is NOT in the end of the array
			// flip from 0 --> maxIndex to move maxValue to the start of the array
			// then flip the whole array to move maxValue to the end of the array
			if(maxIndex != currentSize - 1) {
				flip(arr, maxIndex);
				System.out.println("++ after flip from:: 0 to " + maxIndex);
				printArr(arr);
				System.out.println();
				
				flip(arr, currentSize-1);
				System.out.println("++ after flip from:: 0 to " + (currentSize-1));
				printArr(arr);
				System.out.println();
			} else {
				System.out.println("Skip flipping...");
			}
		}
		return arr;
	}
	
	void flip(Integer[] arr, int end) {
		int start = 0;
		while(start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}
	
	int findMax(Integer[] arr, int n) {
		int ret = 0;
		for(int i=1; i<n; i++) {
			if(arr[ret] < arr[i]) {
				ret = i;
			}
		}
		return ret;
	}
}
