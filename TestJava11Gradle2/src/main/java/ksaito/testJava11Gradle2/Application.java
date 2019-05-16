package ksaito.testJava11Gradle2;

import ksaito.testJava11Gradle2.userUtilities.SystemUtilities;

public class Application {
    public static void main(String[] args) {
        SystemUtilities.print(SystemUtilities.getProperty("java.class.path"));
        Executer.run();
    }
}
