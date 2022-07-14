package com.example.java8.entity;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Car {

	private final Integer id;
	private final String make;
	private final String model;
	private final String color;
	private final Integer year;
	private final Double price;

	public Car(Integer id, String make, String model, String color, Integer year, Double price) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public Integer getYear() {
		return year;
	}

	public Double getPrice() {
		return price;
	}

	@Override
	  public String toString() {
	    return "Car{" +
	        "id=" + id +
	        ", make='" + make + '\'' +
	        ", model='" + model + '\'' +
	        ", color='" + color + '\'' +
	        ", year=" + year +
	        ", price=" + price +
	        '}';
	  }
	
	public static void main(String[] args) {
//		String s1 = "FB";
//		String s2 = "Ea";
//		String s3 = "DD";
//		String s4 = "DD";
//		System.out.println(s1.hashCode() + " - " + s2.hashCode());
//		Map<String, Integer> map = new HashMap<>();
////		
////		map.put("aaa", 1);
////		map.put("bbb", 2);
////		map.put("ccc", 3);
////		map.put("ddd", 4);
////		
//		map.put(s1, 11);
//		map.put(s2, 22);
//		map.put(s3, 33);
//		System.out.println(map.get(s3));
////		System.out.println("Aaa");
////		
//		Person p = new Person(1, "", "1", "1", "1", 10);
//		Person p1 = new Person(1, "", "1", "1", "1", 10);
//		System.out.println(p.equals(p1));
////		System.out.println(p.hashCode());
////		System.out.println(p1.hashCode());
//		System.out.println("ADD".equals("ADD"));
//		
//		Map<Integer, Person> aa;
//		
//		
//		System.out.println(p.equals(p1));
//				
//		System.out.println(s3 == s4);
		
		Queue<Integer> pQueue = new PriorityQueue<Integer>();
		pQueue.add(1);
        pQueue.add(2);
        pQueue.add(3);
        pQueue.peek();
        
        printQueue(pQueue);
        
        System.out.println("peek");
//        System.out.println(pQueue.peek());
        
        System.out.println("poll");
        System.out.println("polled:: " + pQueue.poll());
        printQueue(pQueue);
//        System.out.println(pQueue.peek());
	}
	
	private static void printQueue(Queue<Integer> queue) {
		Iterator<Integer> iterator = queue.iterator();
		  
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
	}
}