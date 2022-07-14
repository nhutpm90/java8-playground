package com.example.java8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java8.entity.Person;
import com.example.java8.testing.utils.MockData;
import com.google.common.collect.ImmutableList;

@SpringBootTest
class Java8Practices_01Tests {

	@Test
	void contextLoads() {
	}

	@Test
	void practice02() {
		List<Integer> list = null;
		int start=1;
		int end=50;
		// gerenate 5 random number
		// using Stream.generate
//		list = Stream.generate(new Random()::nextInt).limit(5).collect(Collectors.toList());
		
		// Create an array from 10 to 50
		// using Stream.iterate
//		list = Stream.iterate(1, n -> n + 1).skip(10).limit(40).collect(Collectors.toList());
		
		// using IntStream.range
//		list = IntStream.range(10, 51).boxed().collect(Collectors.toList());
		
		// using IntStream.
		list = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
		
		System.out.println("-----Data");
		System.out.println(list);
		
		// find even number which greater than 25
		System.out.println("------01");
		list.stream().filter(item -> item > 25 && item % 2 == 0).forEach(item -> System.out.print(item + " "));
		
		// sum list
		System.out.println();
		System.out.println("------02");
		Integer sum = list.stream().reduce(0, (total, item) -> total + item);
		System.out.println("sum:: " + sum);
		
		// max number in list
		System.out.println("------03");
		Integer max = list.stream().max(Integer::compare).get();
		System.out.println(max);
		
		// sort list
		System.out.println("------04");
		// asc
		System.out.println(list.stream().sorted().collect(Collectors.toList()));
		// desc
		System.out.println(list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));
	}
	
	
	@Test
	public void practice17() throws Exception {
//		  {
//		    "id": 1,
//		    "firstName": "Dixie",
//		    "lastName": "O'Finan",
//		    "email": "dofinan0@huffingtonpost.com",
//		    "gender": "Female",
//		    "age": 91
//		  },
		ImmutableList<Person> people = MockData.getPeople();

		List<Person> list = people.stream().limit(20).collect(Collectors.toList());
		// print list
		System.out.println("------01");
//		list.forEach(System.out::println);
		
		// print list with index
		System.out.println("------02");
		IntStream.range(0, list.size()).forEach(i -> {
			Person person = list.get(i);
			System.out.println(i + " - " + person);
		});
		
		// sort list by age
		System.out.println("------03");
		list.stream().sorted(Comparator.comparingInt(Person::getAge)).forEach(System.out::println);
		
		// sort list by age and firstName
		System.out.println("------04");
		list.stream().sorted((o1, o2) -> {
			int ret = Integer.compare(o1.getAge(), o2.getAge());
			if(ret == 0) {
				ret = o1.getFirstName().compareTo(o2.getFirstName());
				// desc
				ret*=-1;
			}
			return ret;
		})
		.forEach(System.out::println);;
		
		// find people with firstname = Jeramie
		System.out.println("------05");
		list.stream().filter(item -> "Jeramie".equals(item.getFirstName())).forEach(System.out::println);
		
		// find people with ids belong to list
		System.out.println("------06");
		List<Integer> ids = Arrays.asList(1,3,5);
		list.stream().filter(item -> ids.contains(item.getId())).forEach(System.out::println);
		System.out.println("------");
		list.stream().filter(item -> ids.stream().anyMatch(id -> id == item.getId())).forEach(System.out::println);
		System.out.println("------");
		ids.stream().flatMap(id -> people.stream().filter(item -> item.getId() == id)).forEach(System.out::println);;
		
		// group people by age
		System.out.println("------07");
		Map<Integer, List<Person>> groupByAgeMap = list.stream().collect(Collectors.groupingBy(Person::getAge));
		groupByAgeMap.forEach((age, peopleByAge) -> {
			System.out.println(age + " - " + peopleByAge);
		});
		
		// group people with age > 60
		System.out.println("------08");
		Map<Boolean, List<Person>> groupByAgeGT60Map = list.stream().collect(Collectors.partitioningBy(item -> item.getAge() > 60));
		groupByAgeGT60Map.forEach((result, gt60People) -> {
			System.out.println(result + " - " + gt60People);
		});
		
		// find oldest person
		System.out.println("------09");
		Person oldestPerson = list.stream().collect(Collectors.collectingAndThen(
				Collectors.maxBy((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())),
				person -> person.get()
			));
		System.out.println(oldestPerson);
	}
	
	@Test
	void practice14() throws IOException {
		ImmutableList<Person> people = MockData.getPeople();
		List<Person> list = people.stream().limit(20).collect(Collectors.toList());
		
		System.out.println("------01");
		// convert people List<person> to Map<id,person>
		Map<Integer, Person> map = list.stream().collect(Collectors.toMap(Person::getId, item -> item));
		map.forEach((k,v) -> System.out.println(k + " - " + v));
		
		// sort map by key
//		map.entrySet().stream().sorted(Entry.comparingByKey()).forEachOrdered(System.out::println);
		
		// sort person map by age
		System.out.println("------02");
		map.entrySet().stream().sorted((o1, o2) -> {
			return o1.getValue().getAge().compareTo(o2.getValue().getAge());
		}).forEachOrdered(System.out::println);
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
	void practice03() {
		List<String> list = Arrays.asList("one", "two");
		// convert to List<>{ 'o','n','e'... }
		List<String> ret = list.stream()
				.map(item -> item.split(""))
				.flatMap(Arrays::stream)
				.collect(Collectors.toList());
		System.out.println(ret);
	}
	
	@Test
	void practice04() {
		List<List<String>> list = Arrays.asList(
									Arrays.asList("one", "two"), 
									Arrays.asList("three", "four")
								);
		// convert to List<>{ 'o','n','e'... }
		List<String> ret = list.stream().flatMap(Collection::stream)
					.map(item -> item.split(""))
					.flatMap(Arrays::stream)
					.collect(Collectors.toList());
		System.out.println(ret);
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
		// convert to List<>{ 'o','n','e'... }
		List<String> ret = list.stream().flatMap(Collection::stream)
					.flatMap(Collection::stream)
					.map(item -> item.split("")).flatMap(Arrays::stream)
					.collect(Collectors.toList());
		System.out.println(ret);
	}
	
	@Test
	void runAyncTest() throws InterruptedException, ExecutionException {
		// 1. create a thread to run a task
		// 2. print a message from main thread
		// 3. waiting for async thread to complete
		// 4. print another message from main thread
		
		System.out.println("mainthread:: create thread to run tasks");
		CompletableFuture<Void> async = CompletableFuture.runAsync(() -> {
			try {
				System.out.println("inside thread:: doing tasks");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("inside thread:: done tasks");
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		});
		System.out.println("mainthread:: do some tasks");
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println("mainthread:: waiting for thread to complete");
		async.get();
		System.out.println("mainthread:: finish all");
	}
	
	@Test
	void supplyAsyncTest() throws InterruptedException, ExecutionException {
		System.out.println("mainthread:: create thread to run tasks");
		CompletableFuture<String> async = CompletableFuture.supplyAsync(() -> {
			String result = null;
			try {
				System.out.println("inside thread:: doing tasks");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("inside thread:: done tasks");
				result = "ok";
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			return result;
		});
		System.out.println("mainthread:: do some tasks");
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println("mainthread:: waiting for thread to complete");
		String resultFromThread = async.get();
		
		System.out.println("resultFromThread:: " + resultFromThread);
		System.out.println("mainthread:: finish all");
	}
	
	@Test
	void thenApplyTest() throws InterruptedException, ExecutionException {
		System.out.println("mainthread:: create thread to run tasks");
		CompletableFuture<String> async = CompletableFuture.supplyAsync(() -> {
			String result = null;
			try {
				System.out.println("inside hello thread:: doing tasks");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("inside hello thread:: done tasks");
				result = "hello";
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			return result;
		}).thenApply(result -> {
			try {
				System.out.println("inside world thread:: doing tasks");
				TimeUnit.SECONDS.sleep(2);
				System.out.println("inside world thread:: done tasks");
				result += " world";
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			return result;
		});
		
		
		System.out.println("mainthread:: do some tasks");
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println("mainthread:: waiting for thread to complete");
		String resultFromThread = async.get();
		
		System.out.println("resultFromThread:: " + resultFromThread);
		System.out.println("mainthread:: finish all");
	}
	
	@Test
	public void practice20() throws Exception {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("FB", 1);
		map.put("Ea", 2);
		System.out.println("Aaa");
	}
	
}
