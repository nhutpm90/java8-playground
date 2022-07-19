package com.example.java8.solid.oc.demo01.after;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SeniorDiscount implements Discount {

	private BigDecimal percent;

	public SeniorDiscount() {
		this.percent = new BigDecimal("0.2");
	}

	@Override
	public BigDecimal apply(BigDecimal price) {
		BigDecimal discount = price.multiply(percent);
		return price.subtract(discount.setScale(2, RoundingMode.HALF_UP));
	}
}

