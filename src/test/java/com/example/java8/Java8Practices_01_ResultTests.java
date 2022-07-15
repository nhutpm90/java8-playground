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
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java8.entity.Person;
import com.example.java8.testing.utils.MockData;
import com.google.common.collect.ImmutableList;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@SpringBootTest
class Java8Practices_01_ResultTests {

	@Test
	void contextLoads() {
	}

	private void breakLine(String header) {
		System.out.println("\n-----" + header);
	}
	
	@Test
	void _01() {
		List<Integer> list = Collections.emptyList();
		int start=1;
		int end=50;
		
		// gerenate 5 random number
		// using Stream.generate
//		list = Stream.generate(new Random()::nextInt).limit(5).collect(Collectors.toList());
//		list = Stream.generate(
		
		// Create an array from 10 to 50
		// using Stream.iterate
//		list = Stream.iterate(1, n -> n + 1).skip(10).limit(40).collect(Collectors.toList());
//		list = Stream.iterate(
				
		// using IntStream.range
//		list = IntStream.range(10, 51).boxed().collect(Collectors.toList());
//		list = IntStream.range(
		
		// using IntStream
		list = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
//		list = IntStream.rangeClosed
		
		breakLine("Data");
		System.out.println(list);
		
//		// find even number which greater than 25
		breakLine("------01 - find even number which greater than 25");
		System.out.println(list);
		List<Integer> evenNumbersList = Collections.emptyList();
//		evenNumbersList = list.stream().filter(item -> item > 25 && item % 2 == 0).collect(Collectors.toList());
//		evenNumbersList = list.stream()
		System.out.println(evenNumbersList);
		
		// sum list
		System.out.println();
		breakLine("------02 - sum list");
		System.out.println(list);
		Integer sum = null;
//		sum = list.stream().reduce(0, (total, item) -> total + item);
//		sum = list.stream()
		System.out.println("sum:: " + sum);
		
		// max number in list
		breakLine("------03 - max number in list");
		System.out.println(list);
		Integer max = null;
//		max = list.stream().max(Integer::compare).get();
//		max = list.stream().max((o1, o2) -> Integer.compare(o1, o2)).get();
//		max = list.stream()
		System.out.println("max:: " + max);
		
		// sort list
		breakLine("------04 - sort list");
		System.out.println(list);
		// asc
		System.out.println("listAsc");
		List<Integer> listAsc = Collections.emptyList(); 
//		listAsc = list.stream().sorted().collect(Collectors.toList());
//		listAsc = list.stream().sorted((o1, o2) -> Integer.compare(o1, o2)).collect(Collectors.toList());
//		listAsc = list.stream()
		System.out.println(listAsc);
		
		// desc
		System.out.println("\nlistDesc");
		List<Integer> listDesc = Collections.emptyList();
//		listDesc = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
//		listDesc = list.stream().sorted((o1, o2) -> -Integer.compare(o1, o2)).collect(Collectors.toList());
//		listDesc = list.stream()
		System.out.println(listDesc);
	}
	
	
	@Test
	public void _02() throws Exception {
//		  {
//		    "id": 1,
//		    "firstName": "Dixie",
//		    "lastName": "O'Finan",
//		    "email": "dofinan0@huffingtonpost.com",
//		    "gender": "Female",
//		    "age": 91
//		  },
		ImmutableList<Person> people = MockData.getPeople();

		// get first 20 people
		final List<Person> list; 
		list = people.stream().limit(20).collect(Collectors.toList());
		
		// print list using forEach
//		breakLine("------01");
//		list.forEach(System.out::println);
		
		// print list with index using IntStream
		breakLine("------02 - loop with index");
//		IntStream.range(0, list.size()).forEach(i -> {
//			Person person = list.get(i);
//			System.out.println(i + " - " + person);
//		});
//		IntStream.range
		
		// sort list by age
		breakLine("------03 - sort list by age");
		List<Person> listByAgeAsc = Collections.emptyList();
//		listByAgeAsc = list.stream().sorted(Comparator.comparingInt(Person::getAge))
//				.collect(Collectors.toList());
//		listByAgeAsc = list.stream().sorted((o1, o2) -> o1.getAge().compareTo(o2.getAge()))
//				.collect(Collectors.toList());
//		listByAgeAsc = list.stream()
		listByAgeAsc.forEach(System.out::println);
		
		// sort list by age and firstName
		breakLine("------04 - sort list by age and firstName");
		List<Person> listByAgeAndFirstNameAsc = Collections.emptyList();
//		listByAgeAndFirstNameAsc = list.stream().sorted((o1, o2) -> {
//			int ret = Integer.compare(o1.getAge(), o2.getAge());
//			if(ret == 0) {
//				ret = o1.getFirstName().compareTo(o2.getFirstName());
//				// desc
//				ret*=-1;
//			}
//			return ret;
//		}).collect(Collectors.toList());
//		listByAgeAndFirstNameAsc = list.stream()
		listByAgeAndFirstNameAsc.forEach(System.out::println);
		
		// find people with firstname = Jeramie
		breakLine("------05 - find people with firstname = Jeramie");
		List<Person> listByFirstName = Collections.emptyList();;
//		listByFirstName = list.stream().filter(item -> "Jeramie".equals(item.getFirstName())).collect(Collectors.toList());
//		listByFirstName = list.stream()
		listByFirstName.forEach(System.out::println);
		
		// find people with ids belong to list
		List<Person> listByIds = Collections.emptyList();;
		List<Integer> ids = Arrays.asList(1,3,5);
		breakLine("------06 - find people with ids belong to list " + ids);
		// using ids.contains
//		listByIds = list.stream().filter(item -> ids.contains(item.getId())).collect(Collectors.toList());
//		listByIds = list.stream()
		listByIds.forEach(System.out::println);
		
		System.out.println("------");
		// using anyMatch
//		listByIds = list.stream().filter(item -> ids.stream().anyMatch(id -> id == item.getId())).collect(Collectors.toList());
//		listByIds = list.stream()
		listByIds.forEach(System.out::println);
		
		System.out.println("------");
//		listByIds = ids.stream().flatMap(id -> people.stream().filter(item -> item.getId() == id)).collect(Collectors.toList());
//		listByIds = ids.stream()
		listByIds.forEach(System.out::println);
		
		// group people by age
		breakLine("------07 - group people by age");
		Map<Integer, List<Person>> groupByAgeMap = Collections.emptyMap();
//		groupByAgeMap = list.stream().collect(Collectors.groupingBy(Person::getAge));
//		groupByAgeMap = list.stream()
		groupByAgeMap.forEach((age, peopleByAge) -> {
			System.out.println(age + " - " + peopleByAge);
		});
		
		// group people with age > 60
		breakLine("------08 - group people with age > 60");
		Map<Boolean, List<Person>> groupByAgeGT60Map = Collections.emptyMap();
//		groupByAgeGT60Map = list.stream().collect(Collectors.partitioningBy(item -> item.getAge() > 60));
//		groupByAgeGT60Map = list.stream()
		groupByAgeGT60Map.forEach((result, gt60People) -> {
			System.out.println(result + " - " + gt60People);
		});
		
		// find oldest person
		breakLine("------09 - find oldest person");
		Person oldestPerson = null;
//		oldestPerson = list.stream().collect(Collectors.collectingAndThen(
//			Collectors.maxBy((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())),
//			person -> person.get()
//		));
//		oldestPerson = list.stream()
		System.out.println(oldestPerson);
	}
	
	@Test
	void _03() throws IOException {
		ImmutableList<Person> people = MockData.getPeople();
		List<Person> list = people.stream().limit(20).collect(Collectors.toList());
		
		breakLine("------01 - convert people to map");
		// convert people List<person> to Map<id,person>
		Map<Integer, Person> map = Collections.emptyMap();
//		map = list.stream().collect(Collectors.toMap(Person::getId, item -> item));
//		map = list.stream()
		map.forEach((k,v) -> System.out.println(k + " - " + v));
		
		// sort map by key
//		map.entrySet().stream().sorted(Entry.comparingByKey()).forEachOrdered(System.out::println);
		
		// sort person map by age
		breakLine("------02");
//		map.entrySet().stream().sorted((o1, o2) -> {
//			return o1.getValue().getAge().compareTo(o2.getValue().getAge());
//		}).forEachOrdered(System.out::println);
	}
	
	@Test
	public void _04() throws Exception {
		breakLine("stack");
		Stack<Integer> stack = new Stack<>();
		stack.push(19);
		stack.push(4);
		stack.push(0);
		stack.push(22);
		stack.push(15);
		stack.forEach(System.out::println);
		System.out.println("stack.pop():: " + stack.pop());
		stack.forEach(System.out::println);
		
		breakLine("queue");
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
	void _05() {
		List<String> ret = Collections.emptyList();
		
		breakLine("------01");
		List<String> list1 = Arrays.asList("one", "two");
		System.out.println(list1);
		// convert to List<>{ 'o','n','e'... }
//		ret = list1.stream()
//				.map(item -> item.split(""))
//				.flatMap(Arrays::stream)
//				.collect(Collectors.toList());
//		ret = list.stream()
		System.out.println(ret);
		
		breakLine("------02");
		List<List<String>> list2 = Arrays.asList(
				Arrays.asList("one", "two"), 
				Arrays.asList("three", "four")
			);
		System.out.println(list2);
		// convert to List<>{ 'o','n','e'... }
//		ret = list2.stream().flatMap(Collection::stream)
//				.map(item -> item.split(""))
//				.flatMap(Arrays::stream)
//				.collect(Collectors.toList());
//		ret = list2.stream();
		System.out.println(ret);
		
		breakLine("------03");
		List<List<List<String>>> list3 = Arrays.asList(
				Arrays.asList(
						Arrays.asList("one", "two"),
						Arrays.asList("three", "four")
				),
				Arrays.asList(
						Arrays.asList("five", "six"),
						Arrays.asList("seven", "eight")
				)
			);
		System.out.println(list3);
		// convert to List<>{ 'o','n','e'... }
//		ret = list3.stream().flatMap(Collection::stream)
//					.flatMap(Collection::stream)
//					.map(item -> item.split("")).flatMap(Arrays::stream)
//					.collect(Collectors.toList());
//		ret = list3.stream()
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
