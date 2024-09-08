package com.designpattern.creational.factory.example2;


import java.util.Optional;

public class LogisticsAppClient {

	public static void main(String[] args) {
		Optional<Transport> transportOptional = LogisticsTransportFactory.getTransport("sea");
		transportOptional.ifPresentOrElse(Transport::delivery,
			() -> System.out.println("Invalid business"));
	}
}
