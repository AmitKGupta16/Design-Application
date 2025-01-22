package com.develop.designpattern.observer;

import java.util.HashSet;
import java.util.Set;

public class WheatherPublisher implements Publisher {
    private Set<Observer> observers;
    private String city;
    private float temperature;
    private float humidity;
    private float pressure;
    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(city, temperature, humidity, pressure));
    }

    @Override
    public void addObserver(Observer observer) {
        if (observers == null) {
            observers = new HashSet<>();
        }
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void setData(String city, float temperature, float humidity, float pressure) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}
