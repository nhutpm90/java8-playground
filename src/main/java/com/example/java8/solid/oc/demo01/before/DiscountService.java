package com.example.java8.solid.oc.demo01.before;

import java.math.BigDecimal;

public class DiscountService {

	public BigDecimal applyDiscount(BigDecimal price, Object discount) {
		if(discount instanceof BasicDiscount) {
			return ((BasicDiscount) discount).apply(price);
		} else if(discount instanceof SeniorDiscount) {
			return ((SeniorDiscount) discount).apply(price);
		}
		return null;
	}
}

