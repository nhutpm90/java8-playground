package com.example.java8.testing;

import java.util.function.Function;

public class FunctionalInterfaceTesting {
	
	public static void main(String[] args) {
//		Predicate<Integer> isEven = i -> i % 2 == 0;
//		System.out.println("10 isEven:: " + isEven.test(10));
//
//		Predicate<Integer> isGreaterThan5 = i -> i > 5;
//		System.out.println("4 isGreaterThan5:: " + isGreaterThan5.test(4));
//		
//		Predicate<Integer> and = isEven.and(isGreaterThan5);
//		System.out.println("60 isEven & isGreaterThan5:: " + isEven.and(isGreaterThan5).test(60));
//		
//		System.out.println("5 is not even:: " + isEven.negate().test(5));
//		
//		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//		List<Integer> filteredList = list.stream().filter(isEven.and(isGreaterThan5)).collect(Collectors.toList());
//		System.out.println("numbers are even and greaterThan5:: " + filteredList);
//		
//		Predicate<String> checkEquality = Predicate.isEqual("Testing");
//		System.out.println("Testing equalsTo Testing:: " + checkEquality.test("Testing"));
	}
	
//	public static void main(String[] args) {
//		Function<String, String> convertStr = input -> input.toUpperCase();
//		System.out.println("uppercase:: " + convertStr.apply("hello function"));
//		
//		Function<String, String> sameValue = Function.identity();
//		System.out.println("same value:: " + sameValue.apply("test"));
//		
//		Function<Integer, Integer> doubleOperation = a -> a * 2;
//		Function<Integer, Integer> tripleOperation = a -> a * 3;
//		System.out.println("5*2*3 = " + doubleOperation.andThen(tripleOperation).apply(5));
//		
//		Function<Integer, Integer> divideOperation = a -> a / 2;
//		divideOperation = divideOperation.compose(a -> a / 3);
//		System.out.println("30/3/2 = " + divideOperation.apply(30));
//	}
	
//	public static void main(String[] args) {
//		UnaryOperator<String> convertStr = input -> input.toUpperCase();
//		System.out.println("uppercase:: " + convertStr.apply("hello function"));
//		
//		UnaryOperator<String> sameValue = UnaryOperator.identity();
//		System.out.println("same value:: " + sameValue.apply("test"));
//		
//		UnaryOperator<Integer> doubleOperation = a -> a * 2;
//		UnaryOperator<Integer> tripleOperation = a -> a * 3;
//		System.out.println("5*2*3 = " + doubleOperation.andThen(tripleOperation).apply(5));
//		
//		UnaryOperator<Integer> divideBy2 = a -> a / 2;
//		UnaryOperator<Integer> divideBy3 = a -> a / 3;
//		System.out.println("30/3/2 = " + divideBy2.compose(divideBy3).apply(30));
//	}
	
//	public static void main(String[] args) {
//		Consumer<String> convertAndDisplay = input -> System.out.println("uppercase value is:: " + input.toUpperCase());
//		Consumer<String> appendAndDisplay = input -> System.out.println("new value is:: " + "hello " + input);
//		convertAndDisplay.andThen(appendAndDisplay).accept("world");
//	}
	
//	public static void main(String[] args) {
//		Supplier<Integer> currentDayOfMonth = () -> LocalDate.now().getDayOfMonth();
//		System.out.println("currentDayOfMonth:: " + currentDayOfMonth.get());
//		
//		Supplier<String> currentDayOfWeek = () -> LocalDate.now().getDayOfWeek().name();
//		System.out.println("currentDayOfWeek:: " + currentDayOfWeek.get());
//		
//		Consumer<Object> a = System.out::println;
//		a.accept("abc");
//	}
	
	
}

