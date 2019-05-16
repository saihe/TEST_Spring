package ksaito.testJava11Gradle;

import ksaito.testJava11Gradle.userClasses.TestCSV;
import ksaito.testJava11Gradle.userClasses.TestDOM4J;
import ksaito.testJava11Gradle.userClasses.TestXML;

public class Executer {
    public static void run() {
        testXML();
//        testCSV();
    }

    public static void testXML() {
        TestXML tx = new TestXML();
        TestDOM4J td = new TestDOM4J();
//        tx.run();
        td.run();
    }
    public static void testCSV() {
        TestCSV ts = new TestCSV();
        ts.transferAtoB();
    }
}
