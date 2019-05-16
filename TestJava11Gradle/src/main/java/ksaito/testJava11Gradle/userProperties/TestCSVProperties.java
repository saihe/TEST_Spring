package ksaito.testJava11Gradle.userProperties;

import java.util.Properties;

public class TestCSVProperties extends BaseProperties{
    public TestCSVProperties() {
        super( "/csv.properties");
    }

    public Properties getProperties() {
        return super.getProperties();
    }
}
