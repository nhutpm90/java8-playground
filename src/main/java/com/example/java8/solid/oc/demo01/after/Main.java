package com.example.java8.solid.oc.demo01.after;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		DiscountService discountService = new DiscountService();
		BigDecimal price = new BigDecimal("100");

		BigDecimal applyBasicDiscount = discountService.applyDiscount(price, new BasicDiscount());
		System.out.println("applyBasicDiscount:: " + applyBasicDiscount);
		
		BigDecimal applySeniorDiscount = discountService.applyDiscount(price, new SeniorDiscount());
		System.out.println("applySeniorDiscount:: " + applySeniorDiscount);
		
		BigDecimal applyAdultDiscount = discountService.applyDiscount(price, new AdultDiscount());
		System.out.println("applyAdultDiscount:: " + applyAdultDiscount);
		
		List<Discount> discounts = Arrays.asList(
				new BasicDiscount(), new SeniorDiscount());
		
		System.out.println("appply two discounts:: " + discountService.applyDiscounts(price, discounts));
	}
}


