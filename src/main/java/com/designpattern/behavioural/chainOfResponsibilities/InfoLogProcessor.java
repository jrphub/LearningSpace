package com.designpattern.behavioural.chainOfResponsibilities;

import java.util.Objects;

public class InfoLogProcessor extends LogProcessor {
	InfoLogProcessor(LogProcessor nextLogProcessor) {
		super(nextLogProcessor);
	}

	@Override
	public void processLog(String message) {
		Objects.requireNonNull(message);
		if (message.contains("INFO")) {
			System.out.println("Processing INFO");
		} else {
			super.processLog(message);
		}
	}
}
