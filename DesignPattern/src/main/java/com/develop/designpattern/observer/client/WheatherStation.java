package com.develop.designpattern.observer.client;

import com.develop.designpattern.observer.MobileObserver;
import com.develop.designpattern.observer.Publisher;
import com.develop.designpattern.observer.WheatherPublisher;

public class WheatherStation {
    public static void main(String[] args) {
        Publisher publisher = new WheatherPublisher();
        publisher.addObserver(new MobileObserver());
        publisher.addObserver(new MobileObserver());
        publisher.setData("Bangalore",24,17,11);
    }
}

