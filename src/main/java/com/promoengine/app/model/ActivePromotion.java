package com.promoengine.app.model;

import java.util.List;

public class ActivePromotion {

	private List<PromoFixed> pf;
	private List<PromoCombined> pc;

	public List<PromoFixed> getPf() {
		return pf;
	}

	public void setPf(List<PromoFixed> pf) {
		this.pf = pf;
	}

	public List<PromoCombined> getPc() {
		return pc;
	}

	public void setPc(List<PromoCombined> pc) {
		this.pc = pc;
	}

	@Override
	public String toString() {
		return "ActivePromotion [pf=" + pf + ", pc=" + pc + "]";
	}

}
