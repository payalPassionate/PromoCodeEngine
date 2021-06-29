package com.promoengine.app.model;

import java.time.LocalDate;

public class PromoCombined {

	private String skuid1;
	private String skuid2;
	private double discountedprice;
	private LocalDate expireddate;

	public LocalDate getExpireddate() {
		return expireddate;
	}

	public void setExpireddate(LocalDate expireddate) {
		this.expireddate = expireddate;
	}

	public String getSkuid1() {
		return skuid1;
	}

	public void setSkuid1(String skuid1) {
		this.skuid1 = skuid1;
	}

	public String getSkuid2() {
		return skuid2;
	}

	public void setSkuid2(String skuid2) {
		this.skuid2 = skuid2;
	}

	public double getDiscountedprice() {
		return discountedprice;
	}

	public void setDiscountedprice(double discountedprice) {
		this.discountedprice = discountedprice;
	}

	@Override
	public String toString() {
		return "PromoCombined [skuid1=" + skuid1 + ", skuid2=" + skuid2 + ", discountedprice=" + discountedprice
				+ ", expireddate=" + expireddate + "]";
	}

}
