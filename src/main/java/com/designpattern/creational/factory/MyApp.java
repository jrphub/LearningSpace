package com.designpattern.creational.factory;

import static com.designpattern.creational.factory.OS_TYPE.LINUX;
import static com.designpattern.creational.factory.OS_TYPE.WINDOWS;

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
