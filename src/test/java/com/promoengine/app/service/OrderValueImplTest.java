package com.promoengine.app.service;

import org.junit.jupiter.api.Test;

import com.promoengine.app.util.MockData;

class OrderValueImplTest {

	@Test
	public void calculatePriceForScenarioA() {
		
		OrderValueImpl oi = new OrderValueImpl();
		double actualprice = oi.calculatePrice(MockData.buildCartItemDetailsForScenarioA());
		System.out.println(actualprice);
		
		assert (actualprice == 100);
	}

}
