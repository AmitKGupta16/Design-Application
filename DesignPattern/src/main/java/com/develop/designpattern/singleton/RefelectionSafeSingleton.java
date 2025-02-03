package com.develop.designpattern.singleton;

public class RefelectionSafeSingleton {
    private static volatile RefelectionSafeSingleton INSTANCE;
    private RefelectionSafeSingleton() {
        if (INSTANCE != null) {
            throw new RuntimeException("Object is already instantiated");
        }
    }
    public static RefelectionSafeSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (RefelectionSafeSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RefelectionSafeSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
