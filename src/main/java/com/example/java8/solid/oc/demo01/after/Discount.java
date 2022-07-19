package com.example.java8.solid.oc.demo01.after;

import java.math.BigDecimal;

public interface Discount {
	
	public BigDecimal apply(BigDecimal price);
	
}
