package com.develop.designpattern.observer;

public interface Publisher {
    void notifyObservers();
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void setData(String data, float temperature, float humidity, float pressure);
}
