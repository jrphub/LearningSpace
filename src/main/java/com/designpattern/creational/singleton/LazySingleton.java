package com.designpattern.creational.singleton;

import java.io.Serializable;

/**
 * Singleton design pattern
 * Objective : To create only one instance of a class
 */
public class LazySingleton implements Serializable {
    //Step1 : initialize instance lazily
    private static LazySingleton instance = null;

    //Step2 : private constructor
    private LazySingleton() {
    }

    //Step3 : Create a static method to return instance of the class
    public static LazySingleton getInstance() {
        //first null check
        if (instance == null) {
            // Step 4 : in case of multi-thread, both T1 and T2 can access this block
            //and can create multiple instances
            //Let's synchronize the block
            synchronized (LazySingleton.class) { // Class level lock
                //double check as T2 should not create new instance
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    //To protect from ClientHackerOne who uses Serialization to create multiple instance
    protected Object readResolve() {
        return instance;
    }
}
