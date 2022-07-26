package com.designpattern.behavioural.observerPattern;

public class Youtube {

    public static void main(String[] args) {
        Channel ch = new Channel();
        Subscriber s1 = new Subscriber("Sumit");
        Subscriber s2 = new Subscriber("Rahul");

        ch.subscribe(s1);;
        ch.subscribe(s2);

        s1.subscribeChannel(ch);
        s2.subscribeChannel(ch);

        ch.upload("Design Pattern in Java");
    }
}
