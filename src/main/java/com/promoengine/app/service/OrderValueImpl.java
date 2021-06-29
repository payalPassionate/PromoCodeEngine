package com.promoengine.app.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.promoengine.app.model.ActivePromotion;
import com.promoengine.app.model.CartItemDetails;
import com.promoengine.app.model.PromoCombined;
import com.promoengine.app.model.PromoFixed;

public class OrderValueImpl implements OrderValue {

	public double calculatePrice(List<CartItemDetails> ci, ActivePromotion ap) {
		List<PromoFixed> pf = ap.getPf();
		List<PromoCombined> pc = ap.getPc();

		double finalPrice = 0;
		HashMap<String, CartItemDetails> checkeligibleForCombinedPromoMap = new HashMap<String, CartItemDetails>();

		for (CartItemDetails item : ci) {

			PromoFixed pfVal = pf.stream()
					.filter(pfval -> pfval.getExpireddate().isEqual(LocalDate.now())
							|| pfval.getExpireddate().isAfter(LocalDate.now()))
					.filter(pfval -> pfval != null).filter(pfval -> pfval.getSkuId().equals(item.getSkuId()))
					.findFirst().orElse(null);

			// Apply fixed promo logic
			if (pfVal != null) {

				finalPrice = finalPrice + ((item.getQuantity() / pfVal.getQuantity()) * pfVal.getDiscountedprice()
						+ (item.getQuantity() % pfVal.getQuantity()) * item.getPeritemprice());
				continue;
			}

			// check for combined promo eligibility and also check if the promo has not been expired
			boolean checkifEligibleForCombinedPromo = false;
			if (pc != null) {
				checkifEligibleForCombinedPromo = pc.stream().filter(
						pcval -> pcval.getSkuid1().equals(item.getSkuId()) || pcval.getSkuid2().equals(item.getSkuId()))
						.filter(pcval -> pcval.getExpireddate().isEqual(LocalDate.now()) || pcval.getExpireddate().isAfter(LocalDate.now())) 
						.filter(pcval -> pcval != null)
						.findFirst().isPresent();
			}

			if (checkifEligibleForCombinedPromo) {
				checkeligibleForCombinedPromoMap.put(item.getSkuId(), item);

			} else {
				finalPrice = finalPrice + item.getQuantity() * item.getPeritemprice();
			}

		}

		finalPrice = calculateCombinedPromoPrice(finalPrice, checkeligibleForCombinedPromoMap, pc);

		return finalPrice;
	}

	private double calculateCombinedPromoPrice(double finalPrice, HashMap<String, CartItemDetails> cartmap,
			final List<PromoCombined> pc) {

		if (cartmap.size() != 1) {
			if (pc != null) {
				for (PromoCombined pcval : pc) {
					if (cartmap.containsKey(pcval.getSkuid1()) && cartmap.containsKey(pcval.getSkuid2())) {
						// apply combined price promo
						CartItemDetails sku1Details = cartmap.get(pcval.getSkuid1());
						CartItemDetails sku2Details = cartmap.get(pcval.getSkuid2());

						finalPrice = finalPrice + (sku1Details.getQuantity() > sku2Details.getQuantity()
								? (sku2Details.getQuantity() * pcval.getDiscountedprice())
										+ (sku1Details.getQuantity() - sku2Details.getQuantity())
												* sku1Details.getPeritemprice()
								: (sku1Details.getQuantity() * pcval.getDiscountedprice())
										+ (sku2Details.getQuantity() - sku1Details.getQuantity())
												* sku2Details.getPeritemprice());

						cartmap.remove(pcval.getSkuid1());
						cartmap.remove(pcval.getSkuid2());
					}
				}
			}
		} else {
			if (!cartmap.isEmpty()) {
				// The map will have only a left over of one item if not empty
				CartItemDetails itemleft = cartmap.values().stream().findFirst().get();
				finalPrice = finalPrice + (itemleft.getPeritemprice() * itemleft.getQuantity());
			}
		}

		return finalPrice;
	}

}
