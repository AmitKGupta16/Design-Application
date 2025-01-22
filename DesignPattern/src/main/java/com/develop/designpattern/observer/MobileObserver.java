package com.develop.designpattern.observer;

public class MobileObserver implements Observer {

    @Override
    public void update(String city, float temperature, float humidity, float pressure) {
        System.out.println("City : " + city + " Temperature : " +   temperature + " Humidity: " + humidity + " Pressure: " + pressure);
    }
}
