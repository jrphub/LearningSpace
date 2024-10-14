package com.designpattern.behavioural.observerPattern;

public class Youtube {

	public static void main(String[] args) {
		ChannelObservable channel = new ChannelObservable();

		ChannelSubscriber s1 = new ChannelSubscriber("X", channel);
		ChannelSubscriber s2 = new ChannelSubscriber("Y", channel);

		channel.addSubscriber(s1);
		channel.addSubscriber(s2);

		channel.upload(new Video("Design Pattern in Java",
			"All about design patterns"));

		channel.removeSubscriber(s2);

		channel.upload(new Video("Java8 functional programming",
			"All about functional Programming"));
	}
}
