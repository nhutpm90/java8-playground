package com.example.java8.solid.oc.demo01.before;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SeniorDiscount {

	private BigDecimal percent;

	public SeniorDiscount() {
		this.percent = new BigDecimal("0.2");
	}

	public BigDecimal apply(BigDecimal price) {
		BigDecimal discount = price.multiply(percent);
		return price.subtract(discount.setScale(2, RoundingMode.HALF_UP));
	}
}

