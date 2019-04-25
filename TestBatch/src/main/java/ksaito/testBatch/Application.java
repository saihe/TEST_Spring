package ksaito.testBatch;

import ksaito.testLibrary.Library01;

public class Application {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        Library01.print("Hello world.");
    }
}
