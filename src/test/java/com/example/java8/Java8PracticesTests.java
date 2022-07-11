package com.example.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java8.entity.Person;
import com.example.java8.entity.Product;
import com.example.java8.testing.utils.MockData;
import com.google.common.collect.ImmutableList;

@SpringBootTest
class Java8PracticesTests {

	@Test
	void contextLoads() {
	}

	@Test
	void practice01() {
		List<String> list = Arrays.asList("Supply", "HR", "Sales", "Marketing");
		/*
		 * expected output: 
		 * [SUPPLY, HR, SALES, MARKETING]
		 */
		
	}
	
	@Test
	void practice02() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		/* conditions:: gt 5 and even
		 * expected output: 
		 * 6 8 10
		 */
	}
	
	@Test
	void practice03() {
		List<String> list = Arrays.asList("one", "two");
		/* 
		 * expected output: 
		 * o n e t w o ...
		 */
//		list.stream().map(item -> item.split("")).flatMap(item -> Stream.of(item)).forEach(item -> System.out.print(item + " "));
		
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
	}
	
	@Test
	void practice06() {
		List<String> list = Arrays.asList("Supply", "HR", "Sales", "Marketing");
		/* condition: print department with name start with "S"
		 * expected output: 
		 * Supply Sales
		 */
	}
	
	@Test
	void practice07() {
		/* condition: generate 5 random numbers
		 */
	}
	
	@Test
	void practice08() {
		/* condition: print number from 11 to 15
		 */
	}
	
	@Test
	void practice09() {
		/* condition: sum from 1 to 5
		 */
	}
	
	@Test
	void practice10() {
		List<Product> list = Arrays.asList(
				new Product("Apple", 1200), 
				new Product("Samsung", 1000),
				new Product("Nokia", 800), 
				new Product("BlackBerry", 1000), 
				new Product("Apple Pro Max", 1500),
				new Product("Mi", 800), 
				new Product("OnePlus", 1000));
		/* conditions:: print product with the max price
		 * expected output: 
		 * Apple Pro Max
		 */
	}
	
	@Test
	void practice11() {
		List<Product> list = Arrays.asList(
				new Product("Apple", 1200), 
				new Product("Samsung", 1000),
				new Product("Nokia", 800), 
				new Product("BlackBerry", 1000), 
				new Product("Apple Pro Max", 1500),
				new Product("Mi", 800), 
				new Product("OnePlus", 1000));
		/* conditions:: group product by price
		 * expected output: 
		 * Map<price, Product>
		 *  800 - [Product [name=Nokia, price=800], Product [name=Mi, price=800]]
			1200 - [Product [name=Apple, price=1200]]
			1000 - [Product [name=Samsung, price=1000], Product [name=BlackBerry, price=1000], Product [name=OnePlus, price=1000]]
			1500 - [Product [name=Apple Pro Max, price=1500]]
		 */
	}
	
	@Test
	void practice12() {
		List<Product> list = Arrays.asList(
				new Product("Apple", 1200), 
				new Product("Samsung", 1000),
				new Product("Nokia", 800), 
				new Product("BlackBerry", 1000), 
				new Product("Apple Pro Max", 1500),
				new Product("Mi", 800), 
				new Product("OnePlus", 1000));
		/* conditions:: group product by price > 1000
		 * expected output: 
		 * Map<boolean, Product>
		 *  false - [Product [name=Samsung, price=1000], Product [name=Nokia, price=800], Product [name=BlackBerry, price=1000], Product [name=Mi, price=800], Product [name=OnePlus, price=1000]]
			true - [Product [name=Apple, price=1200], Product [name=Apple Pro Max, price=1500]]
		 */
	}
	
	@Test
	void practice13() {
		List<Integer> list = Arrays.asList(5, 2, 11, 7, 4, 13, 9);
		/* conditions:: filter even numbers, double the value and sort result asc
		 * expected output: 
		 * [4, 8]
		 */
	}
	
	@Test
	void practice14() {
		Map<String, String> map = new HashMap<>();
		map.put("India", "Delhi");
		map.put("USA", "Washington");
		map.put("Japan", "Tokyo");
		map.put("China", "Beijing");
		map.put("Germany", "Berlin");
		map.put("England", "London");
		
		/* 
		 * print map
		 */
		System.out.println();
		System.out.println("---- Print map");
		
		/* 
		 * sort map by key
		 * expected output: 
			China=Beijing
			England=London
			Germany=Berlin
			India=Delhi
			Japan=Tokyo
			USA=Washington
		 */
		System.out.println();
		System.out.println("---- Sort by key");
		
		/* 
		 * sort map by value
		 * expected output: 
			China=Beijing
			Germany=Berlin
			India=Delhi
			England=London
			Japan=Tokyo
			USA=Washington
		 */
		System.out.println();
		System.out.println("---- Sort by value");
		
//		map.computeIfAbsent("Spain", name -> "Madrid");
//		map.computeIfPresent("USA", (k, v) -> "Washington DC");
//		map.compute("India", (key, val) -> "New " + val);
//		map.remove("England", "London");
//		map.replaceAll((country, capital) -> capital.toUpperCase());
//		map.replace("India", "Delhi");
//		map.entrySet().stream().sorted(Entry.comparingByValue()).forEachOrdered(System.out::println);
	}
	
	@Test
	void practice15() {
		/* join string
		 * expected output: 
		 * Supply,HR,Sales
		 */
	}
	
	@Test
	void practice16() {
		/* loop from 0 --> 9
		 */
		System.out.println("---- Stream.iterate");
		
		System.out.println();
		System.out.println("---- IntStream.range");
		
		System.out.println();
		System.out.println("---- IntStream.rangeClosed");
		
	}
	
	@Test
	public void practice17() throws Exception {
		ImmutableList<Person> people = MockData.getPeople();
		/* loop list with index
		 */
	}
	
}
