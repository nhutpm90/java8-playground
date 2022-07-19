package com.example.java8.solid.oc.demo01.before;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasicDiscount {

	private BigDecimal percent = null;

	public BasicDiscount() {
		this.percent = new BigDecimal("0.1");
	}

	public BigDecimal apply(BigDecimal price) {
		BigDecimal discount = price.multiply(percent);
		return price.subtract(discount.setScale(2, RoundingMode.HALF_UP));
	}
}


