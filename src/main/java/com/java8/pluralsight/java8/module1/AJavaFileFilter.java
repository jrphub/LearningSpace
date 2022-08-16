package com.java8.pluralsight.java8.module1;

import java.io.File;
import java.io.FileFilter;

public class AJavaFileFilter implements FileFilter {
    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(".java");
    }
}
