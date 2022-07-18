package com.example.java8.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlgoPractices_01_ResultTests {

	@Test
	void contextLoads() {
	}

	
	@Test
	void _01() {
		// missing number
		Integer[] source = IntStream.rangeClosed(1, 10).boxed().toArray(Integer[]::new);
		// source [1 2 3 4 5 6 7 8 9 10]
		// arr    [1 2 3 4 5 6 7 9 10]
		// missing number 8
		Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 9, 10 };
		
		Integer result = null;
		// begin
		int sourceSum = 0;
		int arrSum = 0;
		sourceSum = Arrays.stream(source).reduce(0, (total, item) -> total + item);
		arrSum = Arrays.stream(arr).reduce(0, (total, item) -> total + item);
		result = sourceSum - arrSum;
		// end
		Integer expectedResult = _01_result(source, arr);
		System.out.println("result:: " + result + " - expected:: " + expectedResult);
	}
	
	Integer _01_result(Integer[] source, Integer[] arr) {
		int sumSource = 0;
		int sumArr = 0;
		for(int i=0; i<source.length; i++) {
			sumSource+=source[i];
		}
		for(int i=0; i<arr.length; i++) {
			sumArr+=arr[i];
		}
		return sumSource - sumArr;
	}
	
	@Test
	void _02() {
		// contain duplicate
		Integer[] arr = new Integer[] { 1, 2, 3, 4, 6, 6, 7, 9, 10 };
		// contain duplicate --> true (6 6)
		
		Boolean result = null;
		// begin
		// end
		Boolean expectedResult = _02_result(arr);
		System.out.println("result:: " + result + " - expected:: " + expectedResult);
	}
	
	Boolean _02_result(Integer[] arr) {
		boolean ret = false;
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		return ret;
	}
	
	@Test
	void _03() {
		// permutation
		Integer[] arr1 = new Integer[] { 1, 2, 3, 4, 5 };
		Integer[] arr2 = new Integer[] { 2, 3, 1, 5, 4 };
//		Integer[] arr1 = new Integer[] { 1, 2, 3, -3, -2 };
//		Integer[] arr2 = new Integer[] { 1, 1, -1, -1, 1 };
		// permutation --> true
		
		Boolean result = null;
		// begin
		// end
		Boolean expectedResult = _03_result(arr1, arr2);
		System.out.println("result:: " + result + " - expected:: " + expectedResult);
	}
	
	Boolean _03_result(Integer[] arr1, Integer[] arr2) {
		boolean ret = false;
		if(arr1.length != arr2.length) return false;
		
		int sum1 = 0, sum2 = 0;
		int mul1 = 1, mul2 = 1;
		for(int i=0; i<arr1.length; i++) {
			int item1 = arr1[i];
			sum1 += item1;
			mul1 *= item1;
			int item2 = arr2[i];
			sum2 += item2;
			mul2 *= item2;
		}
		ret = sum1 == sum2 && mul1 == mul2;
		return ret;
	}
	
	@Test
	void _04() {
//		Integer[][] arr = { {1,2,3}, {4,5,6}, {7,8,9} };
		Integer[][] arr = { {1,2,3,4}, {5,6,7,8}, {9, 10, 11, 12}, {13, 14, 15, 16} };
		// rotate matrix
		// 1 2 3		7 4 1
		// 4 5 6  -->	8 5 2
		// 7 8 9		9 6 3
		
		// 1 2 3		
		// 4 5 6  
		// 7 8 9
		
		// 7 2 1
		// 4 5 6
		// 9 8 3
		
		
		Boolean result = null;
		// begin
		// end
		Boolean expectedResult = _04_result(arr);
		System.out.println(Arrays.deepToString(arr));
//		System.out.println("result:: " + result + " - expected:: " + expectedResult);
	}
	
	Boolean _04_result(Integer[][] arr) {
		boolean ret = false;
		if(arr.length == 0 || arr.length != arr[0].length) return false;
		int n = arr.length;
		for(int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i=first; i<last; i++) {
				int offset = i - first;
				// top left
				int top = arr[first][i];
				// assign top left to top right
				arr[first][i] = arr[last-offset][first];
				
				arr[last-offset][first] = arr[last][last-offset];
				arr[last][last-offset] = arr[i][last];
				arr[i][last] = top;
				System.out.println(Arrays.deepToString(arr));
			}
		}
		return ret;
	}
	
	@Test
	void _05() {
		// sum diagonal elements
		Integer[][] arr = { {1,2,3}, {4,5,6}, {7,8,9} };
		// 1 2 3
		// 4 5 6
		// 7 8 9
		// sum --> 1 + 5 + 9
		
		Boolean result = null;
		// begin
		// end
		Integer expectedResult = _05_result(arr);
		System.out.println("result:: " + result + " - expected:: " + expectedResult);
	}
	
	Integer _05_result(Integer[][] arr) {
		int ret = 0;
		for(int i=0; i<arr.length; i++) {
			ret += arr[i][i];
		}
		return ret;
	}
	
	@Test
	void _06() {
		// find first and second max numbers
		Integer[] arr = { 1, 15, 7, 9, 11, 15 };
		// result --> 15 11
		
		Boolean result = null;
		// begin
		// end
		System.out.println(Arrays.deepToString(arr));
		Integer[] expectedResult = _06_result(arr);
		System.out.println("result:: " + result 
				+ " - expected:: firstMax::" + expectedResult[0] + " - secondMax::" + expectedResult[1]);
	}
	
	Integer[] _06_result(Integer[] arr) {
		Integer[] ret = new Integer[2];
		Arrays.sort(arr, Collections.reverseOrder());
		// first max
		Integer firstMax = arr[0];
		// second max
		Integer secondMax = null;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] != firstMax) {
				secondMax = arr[i];
				break;
			}
		}
		
		ret[0] = firstMax;
		ret[1] = secondMax;
		return ret;
	}
	
	@Test
	void _07() {
		// remove duplicate
//		int[] arr = { 1, 1, 2, 2, 3, 4, 5 };
		int[] arr = { 1, 2, 2, 3, 4, 5, 5 };
		// remove duplicate --> { 1, 2, 3, 4, 5 }
		
		Boolean result = null;
		// begin
		// end
//		System.out.println(Arrays.deepToString(arr));
//		Boolean expectedResult = _07_result(arr);
		printArr(arr);
		System.out.println();
		int[] expectedResult = removeDuplicates(arr);
		printArr(expectedResult);
//		System.out.println("result:: " + result + " - expected:: " + expectedResult);
	}
	
	Boolean _07_result(Integer[] arr) {
		boolean ret = false;
		if(arr.length < 1) return false;
		
		int j=0;
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] != arr[i + 1]) {
				arr[j++] = arr[i];
			}
		}
		arr[j++] = arr[arr.length-1];
		return ret;
	}
	
	void printArr(int[] arr) {
		Arrays.stream(arr).forEach(item -> System.out.print(item + " - "));
	}
	
	private int removeDuplicates(int a[], int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int j = 0;
		System.out.println();
		for (int i = 0; i < n - 1; i++) {
			System.out.println("loop:: " + i);
			System.out.println("before");
			printArr(a);
			System.out.println();
			System.out.println(String.format("compare:: a[%s]::%s - a[%s]::%s", i,a[i], i+1, a[i+1]));
			if (a[i] != a[i + 1]) {
				System.out.println(String.format("swap:: a[%s] to a[%s]", j, i));
				a[j] = a[i];
				j++;
				System.out.println("increase j from " + (j-1) + " to " + j);
			}
			System.out.println("after");
			printArr(a);
			System.out.println("\n");
		}
		a[j++] = a[n - 1];
		return j;
	}

	public int[] removeDuplicates(int[] arr) {
		int result = removeDuplicates(arr, arr.length);
		int[] newArray = new int[result];
		for (int i = 0; i < result; i++) {
			newArray[i] = arr[i];
		}
		return newArray;
	}
}
