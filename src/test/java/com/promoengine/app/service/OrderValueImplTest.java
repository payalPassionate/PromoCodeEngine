package com.promoengine.app.service;

import org.junit.jupiter.api.Test;

import com.promoengine.app.model.ActivePromotion;
import com.promoengine.app.util.MockData;

class OrderValueImplTest {
	
	/**
	 * Scenario A - Test set Up - Check logic when no promo applied.
	 */
	@Test
	public void calculatePriceForScenarioA() {
		ActivePromotion ap = MockData.buildActivePromotion();
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioA(), ap);
		assert (actualprice == 100);
	}
	
	/**
	 * Scenario B - Test set Up - Check fixed promo logic.
	 */
	@Test
	public void calculatePriceForScenarioB() {
		ActivePromotion ap = MockData.buildActivePromotion();
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioB(), ap);
		assert (actualprice == 370);
	}
	
	/**
	 * Scenario C - Test set Up - Check mix of combine and fixed promo.
	 */
	@Test
	public void calculatePriceForScenarioC() {
		ActivePromotion ap = MockData.buildActivePromotion();
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioC(), ap);
		assert (actualprice == 280);
	}
	
	/**
	 * Scenario D - Test set Up - Check mix of combine and fixed promo - multi Combined promo offers.
	 */
	@Test
	public void calculatePriceForScenarioD() {
		ActivePromotion ap = MockData.buildActivePromotion();
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioD(), ap);
		assert (actualprice == 330);
	}
	
	/**
	 * Scenario E - Test set Up - Check expired fixed promo logic - based on same CartItems details used for sc - B.
	 */
	@Test
	public void calculatePriceForScenarioE() {
		ActivePromotion ap = MockData.buildExpiredActivePromotion();
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioB(), ap);
		assert (actualprice == 420);
	}
	
	/**
	 * Scenario F - Test set Up - Check mix of combine and fixed expired promo. - expired case of Sc C
	 */
	@Test
	public void calculatePriceForScenarioF() {
		ActivePromotion ap = MockData.buildExpiredActivePromotion();
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioC(), ap);
		assert (actualprice == 335);
	}

}
