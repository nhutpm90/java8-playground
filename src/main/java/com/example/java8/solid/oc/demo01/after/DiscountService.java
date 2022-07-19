package com.example.java8.solid.oc.demo01.after;

import java.math.BigDecimal;
import java.util.List;

public class DiscountService {

	public BigDecimal applyDiscount(BigDecimal price, Discount discount) {
		if(discount != null) {
			return discount.apply(price);
		}
		return null;
	}
	
	public BigDecimal applyDiscounts(BigDecimal price, List<Discount> discounts) {
		BigDecimal discountPrice = price.add(BigDecimal.ZERO);
		for (Discount discount : discounts) {
			discountPrice = discount.apply(discountPrice);
		}
		return discountPrice;
	}
}

