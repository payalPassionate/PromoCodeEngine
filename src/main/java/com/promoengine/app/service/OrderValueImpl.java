package com.promoengine.app.service;

import java.util.HashMap;
import java.util.List;

import com.promoengine.app.model.ActivePromotion;
import com.promoengine.app.model.CartItemDetails;
import com.promoengine.app.model.PromoCombined;
import com.promoengine.app.model.PromoFixed;
import com.promoengine.app.util.MockData;

public class OrderValueImpl implements OrderValue {

	public double calculatePrice(List<CartItemDetails> ci) {
		ActivePromotion ap = MockData.buildActivePromotion();
		List<PromoFixed> pf = ap.getPf();
		List<PromoCombined> pc = ap.getPc();

		double finalPrice = 0;
		HashMap<String, CartItemDetails> checkeligibleForCombinedPromoMap = new HashMap<String, CartItemDetails>();

		for (CartItemDetails item : ci) {

			PromoFixed pfVal = pf.stream().filter(pfval -> pfval.getSkuId().equals(item.getSkuId())).findFirst()
					.orElse(null);

			// Apply fixed promo logic
			if (pfVal != null) {

				finalPrice = finalPrice + ((item.getQuantity() / pfVal.getQuantity()) * pfVal.getDiscountedprice()
						+ (item.getQuantity() % pfVal.getQuantity()) * item.getPeritemprice());
				continue;
			}

			// check for combined promo eligibility
			boolean checkifEligibleForCombinedPromo = pc.stream().filter(
					pcval -> pcval.getSkuid1().equals(item.getSkuId()) || pcval.getSkuid2().equals(item.getSkuId()))
					.findFirst().isPresent();

			if (checkifEligibleForCombinedPromo) {
				checkeligibleForCombinedPromoMap.put(item.getSkuId(), item);
			} else {
				finalPrice = finalPrice + item.getQuantity() * item.getPeritemprice();
			}

		}

		return finalPrice;
	}

}
