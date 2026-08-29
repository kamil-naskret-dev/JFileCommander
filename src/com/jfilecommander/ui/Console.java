package com.jfilecommander.ui;

import java.nio.file.Path;
import java.util.List;

public class Console {
    public void printSuccess(String message) {
        System.out.println(message);
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void printResults(List<Path> results) {
        if (results.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            results.forEach(System.out::println);
        }
    }

    public void print(String message) {
        System.out.println(message);
    }
}
