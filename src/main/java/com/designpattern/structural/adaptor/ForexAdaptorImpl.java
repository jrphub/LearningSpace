package com.designpattern.structural.adaptor;

public class ForexAdaptorImpl implements ForexAdaptor {

	MarketPrice price;

	ForexAdaptorImpl(MarketPrice price) {
		this.price = price;
	}

	@Override
	public long cost() {
		return price.cost() * 70;
	}
}
