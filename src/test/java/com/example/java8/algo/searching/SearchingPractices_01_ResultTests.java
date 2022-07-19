package com.example.java8.algo.searching;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SearchingPractices_01_ResultTests {

	@Test
	void contextLoads() {
	}

	void printArr(Integer[] arr) {
		Arrays.stream(arr).forEach(item -> System.out.print(item + " "));
	}
	
	@Test
	void _01() {
		// linear search
		Integer[] arr = new Integer[] { 6, 5, 3, 1, 8, 7, 2, 4 };
//		Integer[] arr = new Integer[] { 6, 5 };
		System.out.println("linear search");
		System.out.println("\ndata:: " + Arrays.deepToString(arr) + "\n- size:: " + arr.length);
		Integer result = null;
		int n = arr.length;
		int valueToSearch = 3;
		// begin
		for(int i=0; i<n; i++) {
			if(arr[i] == valueToSearch) {
				result = i;
				break;
			}
		}
		// end
		Integer expectedResult = _01_result(arr, valueToSearch);
		System.out.println("\nresult:: " + result
						+ "\nexpected:: " + expectedResult);
	}
	
	Integer _01_result(Integer[] arr, Integer target) {
		Integer ret = null;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] == target) {
				ret = i;
				break;
			}
		}
		return ret;
	}
	
	@Test
	void _02() {
		// binary search
		Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		Integer[] arr = new Integer[] { 6, 5 };
		System.out.println("binary search");
		System.out.println("\ndata:: " + Arrays.deepToString(arr) + "\n- size:: " + arr.length);
		Integer result = null;
		int n = arr.length;
		int valueToSearch = 3;
		// begin
		// end
		Integer expectedResult = _02_result(arr, valueToSearch);
		System.out.println("\nresult:: " + result
						+ "\nexpected:: " + expectedResult);
	}
	
	Integer _02_result(Integer[] arr, Integer target) {
		Integer ret = null;
		int n = arr.length;
		int start = 0;
        int end = n - 1;
        while(start < end) {
            int middle = start + (end - start) / 2;
            int temp = arr[middle];
            System.out.println(String.format("\nloop:: start: %s - end: %s - middle: %s - middleValue: %s", 
            		start, end, middle, temp));
            if(temp == target) {
                return middle;
            } else {
                if(temp > target) {
                    end = middle;
                } else {
                    start = middle + 1;
                }
            }
        }
        if(arr[start] == target) {
            ret = start;
        }
		return ret;
	}
}
