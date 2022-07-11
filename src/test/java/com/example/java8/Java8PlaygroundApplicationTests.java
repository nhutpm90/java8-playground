package com.example.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Java8PlaygroundApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void practice01() {
		List<String> departmentList = Arrays.asList("Supply", "HR", "Sales", "Marketing");
		/*
		 * expected output: 
		 * [SUPPLY, HR, SALES, MARKETING]
		 */
		
		departmentList.stream().map(item -> item.toUpperCase()).forEach(System.out::println);
	}
	
	@Test
	void practice02() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		/* conditions:: gt 5 and even
		 * expected output: 
		 * 6 8 10
		 */
		list.stream().filter(item -> item > 5 && item % 2 == 0).forEach(item -> System.out.print(item + " "));
	}
	
	@Test
	void practice03() {
		List<String> list = Arrays.asList("one", "two");
		/* 
		 * expected output: 
		 * o n e t w o ...
		 */
//		list.stream().map(item -> item.split("")).flatMap(item -> Stream.of(item)).forEach(item -> System.out.print(item + " "));
		
		list.stream().map(item -> item.split(""))
					.flatMap(Arrays::stream)
					.forEach(item -> System.out.print(item + " "));
	}
	
	@Test
	void practice04() {
		List<List<String>> list = Arrays.asList(
									Arrays.asList("one", "two"), 
									Arrays.asList("three", "four")
								);
		/* 
		 * expected output: 
		 * o n e t w o t h r e e f o u r ...
		 */
		
		list.stream().flatMap(Collection::stream)
					.map(item -> item.split(""))
					.flatMap(Arrays::stream)
					.forEach(item -> System.out.print(item + " "));;
	}
	
	@Test
	void practice05() {
		List<List<List<String>>> list = Arrays.asList(
				Arrays.asList(
						Arrays.asList("one", "two"),
						Arrays.asList("three", "four")
				),
				Arrays.asList(
						Arrays.asList("five", "six"),
						Arrays.asList("seven", "eight")
				)
			);
		/* 
		 * expected output: 
		 * o n e t w o t h r e e f o u r f i v e...
		 */
		list.stream().flatMap(Collection::stream)
					.flatMap(Collection::stream)
					.map(item -> item.split("")).flatMap(Arrays::stream)
					.forEach(item -> System.out.print(item + " "));
	}
	
	@Test
	void practice06() {
		List<String> list = Arrays.asList("Supply", "HR", "Sales", "Marketing");
		/* condition: print department with name start with "S"
		 * expected output: 
		 * Supply Sales
		 */
		list.stream().filter(item -> item.startsWith("S")).forEach(item -> System.out.print(item + " "));
	}
	
	@Test
	void practice07() {
		/* condition: generate 5 random numbers
		 * expected output: 
		 */
		Stream.generate(new Random()::nextInt).limit(5).forEach(System.out::println);
	}
	
	@Test
	void practice08() {
		/* condition: print number from 11 to 15
		 */
		Stream.iterate(1, n -> n + 1).skip(10).limit(5).forEach(System.out::println);
	}
	
	@Test
	void practice09() {
		/* condition: sum from 1 to 5
		 */
		Integer sum = Stream.iterate(1, n -> n + 1).limit(5).reduce(0, (total, item) -> total + item);
		System.out.println(sum);
	}
}
