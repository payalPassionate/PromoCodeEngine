package com.promoengine.app.util;

import java.util.Arrays;
import java.util.List;

import com.promoengine.app.model.ActivePromotion;
import com.promoengine.app.model.CartItemDetails;
import com.promoengine.app.model.PromoCombined;
import com.promoengine.app.model.PromoFixed;

public class MockData {

	public static List<CartItemDetails> buildCartItemDetailsForScenarioA() {
		CartItemDetails ci = new CartItemDetails();
		ci.setSkuId("A");
		ci.setQuantity(1);
		ci.setPeritemprice(50);

		CartItemDetails ci1 = new CartItemDetails();
		ci1.setSkuId("B");
		ci1.setQuantity(1);
		ci1.setPeritemprice(30);

		CartItemDetails ci2 = new CartItemDetails();
		ci2.setSkuId("C");
		ci2.setQuantity(1);
		ci2.setPeritemprice(20);

		return Arrays.asList(ci, ci1, ci2);
	}
	
	public static List<CartItemDetails> buildCartItemDetailsForScenarioB() {
		CartItemDetails ci = new CartItemDetails();
		ci.setSkuId("A");
		ci.setQuantity(5);
		ci.setPeritemprice(50);

		CartItemDetails ci1 = new CartItemDetails();
		ci1.setSkuId("B");
		ci1.setQuantity(5);
		ci1.setPeritemprice(30);

		CartItemDetails ci2 = new CartItemDetails();
		ci2.setSkuId("C");
		ci2.setQuantity(1);
		ci2.setPeritemprice(20);

		return Arrays.asList(ci, ci1, ci2);
	}

	public static ActivePromotion buildActivePromotion() {
		ActivePromotion ap = new ActivePromotion();
		ap.setPc(buildPromoCombined());
		ap.setPf(buildPromoFixed());

		return ap;
	}

	public static List<PromoFixed> buildPromoFixed() {
		PromoFixed pf = new PromoFixed();
		pf.setSkuId("A");
		pf.setQuantity(3);
		pf.setDiscountedprice(130);

		PromoFixed pf1 = new PromoFixed();
		pf1.setSkuId("B");
		pf1.setQuantity(2);
		pf1.setDiscountedprice(45);

		return Arrays.asList(pf, pf1);
	}

	public static List<PromoCombined> buildPromoCombined() {
		PromoCombined pc = new PromoCombined();
		pc.setSkuid1("C");
		pc.setSkuid2("D");
		pc.setDiscountedprice(30);

		return Arrays.asList(pc);

	}
}
