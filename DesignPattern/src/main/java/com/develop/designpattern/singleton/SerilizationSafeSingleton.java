package com.develop.designpattern.singleton;

import java.io.Serial;
import java.io.Serializable;

public class SerilizationSafeSingleton implements Serializable {
    private static final long  serialVersionUID = 1L;
    private static volatile SerilizationSafeSingleton INSTANCE;
    private SerilizationSafeSingleton() {

    }
    public static SerilizationSafeSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (SerilizationSafeSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SerilizationSafeSingleton();
                }
            }
        }
        return INSTANCE;
    }

    @Serial
    protected Object readResolve() {
        return INSTANCE;
    }
}
