package com.designpattern.structural.adaptor;

public class MarketPriceUSD implements MarketPrice{

	@Override
	public long cost() {
		return 30L;
	}
}
