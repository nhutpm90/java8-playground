package com.example.java8.solid.oc.demo01.before;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		DiscountService discountService = new DiscountService();
		BigDecimal price = new BigDecimal("100");

		BigDecimal applyBasicDiscount = discountService.applyDiscount(price, new BasicDiscount());
		System.out.println("applyBasicDiscount:: " + applyBasicDiscount);
		
		BigDecimal applySeniorDiscount = discountService.applyDiscount(price, new SeniorDiscount());
		System.out.println("applySeniorDiscount:: " + applySeniorDiscount);
	}
}

