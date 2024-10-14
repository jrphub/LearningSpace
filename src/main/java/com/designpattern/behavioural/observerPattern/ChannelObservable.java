package com.designpattern.behavioural.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class ChannelObservable implements Observable {
	//Has-A
	private List<ChannelSubscriber> subs = new ArrayList<>();

	private Video video;

	@Override
	public void addSubscriber(ChannelSubscriber subscriber) {
		subs.add(subscriber);
	}

	@Override
	public void removeSubscriber(ChannelSubscriber subscriber) {
		subs.remove(subscriber);
	}

	@Override
	public void notifySubscribers() {
		for (ChannelSubscriber sub : subs) {
			sub.update();
		}
	}

	@Override
	public void upload(Video video) {
		this.video = video;
		notifySubscribers();
	}

	public String getTitle() {
		return video.getName();
	}
}
