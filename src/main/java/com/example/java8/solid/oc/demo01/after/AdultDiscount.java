package com.example.java8.solid.oc.demo01.after;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AdultDiscount extends BasicDiscount {

	private BigDecimal extraPercent;

	public AdultDiscount() {
		super();
		this.extraPercent = new BigDecimal("0.15");
	}

	@Override
	public BigDecimal apply(BigDecimal price) {
		BigDecimal basicDiscountApply = super.apply(price);
		BigDecimal discount = basicDiscountApply.multiply(extraPercent);
		return price.subtract(discount.setScale(2, RoundingMode.HALF_UP));
	}
}


