package com.promoengine.app.model;

import java.time.LocalDate;

public class PromoFixed {

	private String skuId;
	private int quantity;
	private double discountedprice;
	private LocalDate expireddate;

	
	public LocalDate getExpireddate() {
		return expireddate;
	}

	public void setExpireddate(LocalDate expireddate) {
		this.expireddate = expireddate;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscountedprice() {
		return discountedprice;
	}

	public void setDiscountedprice(double discountedprice) {
		this.discountedprice = discountedprice;
	}

	@Override
	public String toString() {
		return "PromoFixed [skuId=" + skuId + ", quantity=" + quantity + ", discountedprice=" + discountedprice
				+ ", expireddate=" + expireddate + "]";
	}

}
