package com.promoengine.app.model;

public class CartItemDetails {
	private String skuId;
	private int quantity;
	private double peritemprice;

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

	public double getPeritemprice() {
		return peritemprice;
	}

	public void setPeritemprice(double peritemprice) {
		this.peritemprice = peritemprice;
	}

	@Override
	public String toString() {
		return "CartItemDetails [skuId=" + skuId + ", quantity=" + quantity + ", peritemprice=" + peritemprice + "]";
	}

}
