package ksaito.testJava11GradleLocalJar;

import ksaito.testJava11GradleLocalJar.userUtilities.SystemUtilities;

public class Application {
    public static void main(String[] args) {
        SystemUtilities.print(SystemUtilities.getProperty("java.class.path"));
        Executer.run();
    }
}
