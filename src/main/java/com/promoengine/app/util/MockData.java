package com.promoengine.app.util;

import java.util.Arrays;
import java.util.List;

import com.promoengine.app.model.ActivePromotion;
import com.promoengine.app.model.CartItemDetails;
import com.promoengine.app.model.PromoCombined;
import com.promoengine.app.model.PromoFixed;

public class MockData {

	/**
	 * Scenario A - Test set Up - Check logic when no promo applied.
	 * @return
	 */
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
	
	/**
	 * Scenario B - Test set Up - Check fixed promo logic.
	 * @return
	 */
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
	
	/**
	 * Scenario C - Test set Up - Check mix of combine and fixed promo.
	 * @return
	 */
	public static List<CartItemDetails> buildCartItemDetailsForScenarioC() {
		CartItemDetails ci = new CartItemDetails();
		ci.setSkuId("A");
		ci.setQuantity(3);
		ci.setPeritemprice(50);

		CartItemDetails ci1 = new CartItemDetails();
		ci1.setSkuId("B");
		ci1.setQuantity(5);
		ci1.setPeritemprice(30);

		CartItemDetails ci2 = new CartItemDetails();
		ci2.setSkuId("C");
		ci2.setQuantity(1);
		ci2.setPeritemprice(20);
		
		CartItemDetails ci3 = new CartItemDetails();
		ci3.setSkuId("D");
		ci3.setQuantity(1);
		ci3.setPeritemprice(15);

		return Arrays.asList(ci, ci1, ci2, ci3);
	}
	
	/**
	 * Scenario D - Test set Up - Check mix of combine and fixed promo.
	 * Added extra scenario to test Flexi Combine Promo logic.
	 * Item E and F has been added to cart which is eligble for Combine Promo.
	 * The below scenario is enhancement of Scenario C.
	 * @return
	 */
	public static List<CartItemDetails> buildCartItemDetailsForScenarioD() {
		CartItemDetails ci = new CartItemDetails();
		ci.setSkuId("A");
		ci.setQuantity(3);
		ci.setPeritemprice(50);

		CartItemDetails ci1 = new CartItemDetails();
		ci1.setSkuId("B");
		ci1.setQuantity(5);
		ci1.setPeritemprice(30);

		CartItemDetails ci2 = new CartItemDetails();
		ci2.setSkuId("C");
		ci2.setQuantity(1);
		ci2.setPeritemprice(20);
		
		CartItemDetails ci3 = new CartItemDetails();
		ci3.setSkuId("D");
		ci3.setQuantity(1);
		ci3.setPeritemprice(15);
		
		CartItemDetails ci4 = new CartItemDetails();
		ci4.setSkuId("E");
		ci4.setQuantity(1);
		ci4.setPeritemprice(40);
		
		CartItemDetails ci5 = new CartItemDetails();
		ci5.setSkuId("F");
		ci5.setQuantity(1);
		ci5.setPeritemprice(30);

		return Arrays.asList(ci, ci1, ci2, ci3, ci4, ci5);
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
		
		PromoCombined pc1 = new PromoCombined();
		pc1.setSkuid1("E");
		pc1.setSkuid2("F");
		pc1.setDiscountedprice(50);


		return Arrays.asList(pc, pc1);

	}
}
