package com.promoengine.app.model;

public class PromoFixed {

	private String skuId;
	private String quantity;
	private double discountedprice;

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
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
		return "PromoFixed [skuId=" + skuId + ", quantity=" + quantity + ", discountedprice=" + discountedprice + "]";
	}

}
