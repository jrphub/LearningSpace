package com.designpattern.creational.factory.example2;

public class LogisticsAppClient {

	private static Transport transport;

	public static void main(String[] args) {
		//getTransport("road");
		getTransport("sea");
		deliverCargo();
	}

	private static void getTransport(String logisticsType) {
		if ("road".equals(logisticsType)) {
			transport = new RoadLogistics().createTransport();
		} else if ("sea".equals(logisticsType)) {
			transport = new SeaLogistics().createTransport();
		}
	}

	private static void deliverCargo() {
		transport.delivery();
	}
}
