package ksaito.testJava11Gradle;

import ksaito.testJava11Gradle.userUtilities.SystemUtilities;

public class Application {
    public static void main(String[] args) {
        SystemUtilities.print(SystemUtilities.getProperty("java.class.path"));
        Executer.run();
    }
}
