package ksaito.testJava11Gradle2;

import ksaito.testJava11Gradle2.userClasses.TestAWS;
import ksaito.testJava11Gradle2.userUtilities.SystemUtilities;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Executer {
    public static void run() {
        SystemUtilities.print("Hello AWS.");
        log.info("***Slf4jによる出力***");
        try {
            new TestAWS().testS3();
        } catch(Exception e) {
            e.printStackTrace();
            SystemUtilities.exit(9);
        }
    }
}
