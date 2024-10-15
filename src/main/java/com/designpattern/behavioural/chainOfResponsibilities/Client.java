package com.designpattern.behavioural.chainOfResponsibilities;

public class Client {
	public static void main(String[] args) {
		LogProcessor processor =
			new InfoLogProcessor(new ErrorLogProcessor(null));

		processor.processLog("INFO : Hello World");
		processor.processLog("ERROR : Some error occurred");
	}
}
