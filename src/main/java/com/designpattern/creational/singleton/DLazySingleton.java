package com.designpattern.creational.singleton;

import java.io.Serializable;

/**
 * <h3>Singleton design pattern</h3>
 * <br/>
 * <b>Objective</b> : To create only one instance of a class
 *<br/>
 * <b>Implementation</b>
 * 1 - Lazy Initialization - Problem : Multi-thread failure
 * 2 - Thread-safe Singleton - Problem : Slower due to synchronize block
 * 3 - Double-checked locking - Using Volatile keyword
 */
public class DLazySingleton implements Serializable {
    //Step1 : initialize instance lazily
    //private static LazySingleton instance = null;
	private static volatile DLazySingleton instance = null;

    //Step2 : private constructor to prevent instantiation
    private DLazySingleton() {
    }

    //Step3 : Create a static method to return instance of the class
    public static DLazySingleton getInstance() {
        //first null check
        if (instance == null) {
            // Step 4 : in case of multi-thread, both T1 and T2 can access this block
            //and can create multiple instances
            //Let's synchronize the block
            synchronized (DLazySingleton.class) { // Class level lock
                //double check as T2 should not create new instance
                if (instance == null) {
                    instance = new DLazySingleton();
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
