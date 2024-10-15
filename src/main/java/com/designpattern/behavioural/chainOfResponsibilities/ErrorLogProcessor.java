package com.designpattern.behavioural.chainOfResponsibilities;

import java.util.Objects;

public class ErrorLogProcessor extends LogProcessor {
	ErrorLogProcessor(LogProcessor nextLogProcessor) {
		super(nextLogProcessor);
	}


	@Override
	public void processLog(String message) {
		Objects.requireNonNull(message);
		if (message.contains("ERROR")) {
			System.out.println("Processing ERROR");
		} else {
			super.processLog(message);
		}
	}
}
