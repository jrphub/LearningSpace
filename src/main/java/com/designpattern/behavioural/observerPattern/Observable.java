package com.designpattern.behavioural.observerPattern;

public interface Observable {
	void addSubscriber(ChannelSubscriber subscriber);

	void removeSubscriber(ChannelSubscriber subscriber);

	void notifySubscribers();

	void upload(Video video);
}
