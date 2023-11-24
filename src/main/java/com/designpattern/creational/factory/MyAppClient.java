package com.designpattern.creational.factory;

public class MyAppClient {
    public static void main(String[] args) {
        MyApp app = new MyApp();
        String directoryType = app.getDirectoryType(OS_TYPE.LINUX);
        System.out.println(directoryType);

    }
}
