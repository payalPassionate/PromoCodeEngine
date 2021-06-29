package com.promoengine.app.service;

import java.util.List;

import com.promoengine.app.model.ActivePromotion;
import com.promoengine.app.model.CartItemDetails;

public interface OrderValue {
	
	double calculatePrice(List<CartItemDetails> ci, ActivePromotion ap);

}
