package ksaito.testJava11Gradle.userUtilities;

import java.util.List;

public class SystemUtilities {
    public static String getProperty(String key) {
        return System.getProperty(key);
    }
    public static void exit(int exitCode) {
        System.exit(exitCode);
    }
    public static void print(String str) {
        System.out.println(str);
    }
    public static void print(List<String> strList) {
        strList.forEach(str -> System.out.println(str));
    }
}
