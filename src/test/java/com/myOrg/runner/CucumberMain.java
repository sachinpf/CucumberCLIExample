package com.myOrg.runner;
import io.cucumber.core.cli.Main;

public class CucumberMain extends Main {
    public static void main(String[] argv) {
        byte exitStatus = run(argv, Thread.currentThread().getContextClassLoader());
        // System.exit(exitStatus);
    }
}