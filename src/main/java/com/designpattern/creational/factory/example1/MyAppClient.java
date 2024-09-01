package com.designpattern.creational.factory.example1;

public class MyAppClient {
    public static void main(String[] args) {
        MyApp app = new MyApp();
        String directoryType = app.getDirectoryType(OS_TYPE.LINUX);
        System.out.println(directoryType);

    }
}
