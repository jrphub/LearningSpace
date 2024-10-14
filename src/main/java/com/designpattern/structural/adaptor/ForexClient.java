package com.designpattern.structural.adaptor;

public class ForexClient {

	public static void main(String[] args) {
		ForexAdaptor adaptor = new ForexAdaptorImpl(new MarketPriceUSD());
		System.out.println("Cost in INR : " + adaptor.cost());
	}
}
