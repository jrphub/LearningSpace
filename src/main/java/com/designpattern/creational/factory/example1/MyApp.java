package com.designpattern.creational.factory.example1;

public class MyApp {
    public String getDirectoryType(OS_TYPE osType) {
        switch (osType) {
            case LINUX:
                return new LinuxOs().getDirectoryType();
            case WINDOWS:
                return new WindowsOs().getDirectoryType();
            default:
                return "Unsupported OS";
        }
    }
}
