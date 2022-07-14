package com.example.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
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
class Java8PracticesResultTests {

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
		
		list.stream().map(item -> item.toUpperCase()).forEach(System.out::println);
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
//		Stream<String> stream2 = list.stream();
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
		
//		list.stream().flatMap(Collection::stream)
//					.map(item -> item.split(""))
//					.flatMap(Arrays::stream)
//					.forEach(item -> System.out.print(item + " "));;
					
		Stream<String> flatMap = list.stream().flatMap(item -> item.stream());
		Stream<String[]> map = flatMap.map(item -> item.split(""));
		Stream<String> aa = map.flatMap(Arrays::stream);
		
		
		aa.forEach(System.out::println);
		
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
		String ret = list.stream().collect(Collectors.collectingAndThen(
					Collectors.maxBy(Comparator.comparing(Product::getPrice)),
					product -> product.get().getName()
				));
		System.out.println(ret);
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
		Map<Integer, List<Product>> ret = list.stream().collect(Collectors.groupingBy(Product::getPrice));
		ret.forEach((key, val) -> System.out.println(key + " - " + val));
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
		Map<Boolean, List<Product>> ret = list.stream().collect(Collectors.partitioningBy(item -> item.getPrice() > 1000));
		ret.forEach((key, val) -> System.out.println(key + " - " + val));
	}
	
	@Test
	void practice13() {
		List<Integer> list = Arrays.asList(5, 2, 11, 7, 4, 13, 9);
		/* conditions:: filter even numbers, double the value and sort result asc
		 * expected output: 
		 * [4, 8]
		 */
		List<Integer> ret = list.stream().filter(item -> item % 2 == 0).map(item -> item * 2).sorted().collect(Collectors.toList());
		System.out.println(ret);
		
		list = Arrays.asList(4, 2, 2, 7, 9, 13, 10);
		/* conditions:: find the first number that greater than 5
		 * if nothing is found, print -1
		 * expected output: 
		 * 7
		 */
		int condition = 5;
		Integer result = list.stream().filter(item -> item > condition).findFirst().orElse(-1);
		System.out.println(result);
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
		map.forEach((k, v) -> System.out.println(k + " : " + v));
		
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
		map.entrySet().stream().sorted(Entry.comparingByKey()).forEachOrdered(System.out::println);
		
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
		map.entrySet().stream().sorted(Entry.comparingByValue()).forEachOrdered(System.out::println);
		
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
		String joined = String.join(",", "Supply", "HR", "Sales");
		System.out.println(joined);
	}
	
	@Test
	void practice16() {
		/* loop from 0 --> 9
		 */
		System.out.println("---- Stream.iterate");
		Stream.iterate(0, n -> n + 1).limit(10).forEach(System.out::println);
		System.out.println();
		System.out.println("---- IntStream.range");
		IntStream.range(0, 10).forEach(System.out::println);
		System.out.println();
		System.out.println("---- IntStream.rangeClosed");
		IntStream.rangeClosed(0, 9).forEach(System.out::println);
	}
	
	@Test
	public void practice17() throws Exception {
		/* loop list with index
		 */
		ImmutableList<Person> people = MockData.getPeople();
		IntStream.range(0, people.size()).forEach(i -> {
			Person person = people.get(i);
			System.out.println(person);
		});
	}
	
	@Test
	public void practice17_01() throws Exception {
		/* loop list with index
		 */
		ImmutableList<Person> people = MockData.getPeople();
//		IntStream.range(0, people.size()).forEach(i -> {
//			Person person = people.get(i);
//			System.out.println(person);
//		});
		
		List<Integer> ids = Arrays.asList(1,2,3);
		ids.stream().flatMap(id -> people.stream().filter(u -> u.getId() == id))
					.map(u -> u.getFirstName())
					.forEach(System.out::println);
		
		people.stream().filter(u -> ids.stream().anyMatch(id -> id == u.getId()))
					.forEach(System.out::println);
	}
	
	@Test
	public void practice18() throws Exception {
		Stack<Integer> stack = new Stack<>();
		stack.push(19);
		stack.push(4);
		stack.push(0);
		stack.push(22);
		stack.push(15);
		stack.forEach(System.out::println);
		System.out.println("stack.pop():: " + stack.pop());
		stack.forEach(System.out::println);
	}
	
	@Test
	public void practice19() throws Exception {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(19);
		queue.add(4);
		queue.add(0);
		queue.add(22);
		queue.add(15);
		queue.forEach(System.out::println);
		System.out.println("queue.poll():: " + queue.poll());
		queue.forEach(System.out::println);
	}
	
	@Test
	public void practice20() throws Exception {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("FB", 1);
		map.put("Ea", 2);
		System.out.println("Aaa");
	}
	
}
