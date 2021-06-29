package com.promoengine.app.service;

import org.junit.jupiter.api.Test;

import com.promoengine.app.util.MockData;

class OrderValueImplTest {

	/**
	 * Scenario A - Test set Up - Check logic when no promo applied.
	 */
	@Test
	public void calculatePriceForScenarioA() {
		
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioA());
		assert (actualprice == 100);
	}
	
	/**
	 * Scenario B - Test set Up - Check fixed promo logic.
	 */
	@Test
	public void calculatePriceForScenarioB() {
		
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioB());
		assert (actualprice == 370);
	}
	
	/**
	 * Scenario C - Test set Up - Check mix of combine and fixed promo.
	 */
	@Test
	public void calculatePriceForScenarioC() {
		
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioC());
		assert (actualprice == 280);
	}
	
	/**
	 * Scenario D - Test set Up - Check mix of combine and fixed promo - multi Combined promo offers.
	 */
	@Test
	public void calculatePriceForScenarioD() {
		
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioD());
		assert (actualprice == 330);
	}

}
