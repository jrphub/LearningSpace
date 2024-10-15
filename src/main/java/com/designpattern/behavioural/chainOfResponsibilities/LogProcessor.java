package com.designpattern.behavioural.chainOfResponsibilities;

public class LogProcessor {

	LogProcessor nextLogProcessor;

	LogProcessor(LogProcessor nextLogProcessor) {
		this.nextLogProcessor = nextLogProcessor;
	}

	protected void processLog(String message) {
		if (this.nextLogProcessor != null) {
			nextLogProcessor.processLog(message);
		}
	}
}
