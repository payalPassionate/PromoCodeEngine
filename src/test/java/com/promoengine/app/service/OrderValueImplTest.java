package com.promoengine.app.service;

import org.junit.jupiter.api.Test;

import com.promoengine.app.util.MockData;

class OrderValueImplTest {

	@Test
	public void calculatePriceForScenarioA() {
		
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioA());
		assert (actualprice == 100);
	}
	
	@Test
	public void calculatePriceForScenarioB() {
		
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioB());
		assert (actualprice == 370);
	}
	
	@Test
	public void calculatePriceForScenarioC() {
		
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioC());
		assert (actualprice == 280);
	}

}
