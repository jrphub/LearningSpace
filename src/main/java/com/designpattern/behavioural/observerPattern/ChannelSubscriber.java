package com.designpattern.behavioural.observerPattern;

public class ChannelSubscriber implements Subscriber{
	private String subscriberName;

	//Has-A
	private ChannelObservable channel;

	public ChannelSubscriber(String name, ChannelObservable observable) {
		this.subscriberName = name;
		this.channel = observable;
	}

	@Override
	public void update() {
		System.out.println("Hey " + subscriberName + ", " +
			"Video Uploaded about " + this.channel.getTitle());
	}
}
