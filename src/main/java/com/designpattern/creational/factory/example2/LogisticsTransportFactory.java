package com.designpattern.creational.factory.example2;

import java.util.Optional;

public class LogisticsTransportFactory {

	public static Optional<Transport> getTransport(String logisticsType) {
		if ("road".equals(logisticsType)) {
			return Optional.of(new RoadLogistics().createTransport());
		} else if ("sea".equals(logisticsType)) {
			return Optional.of(new SeaLogistics().createTransport());
		}
		return Optional.empty();
	}

}
