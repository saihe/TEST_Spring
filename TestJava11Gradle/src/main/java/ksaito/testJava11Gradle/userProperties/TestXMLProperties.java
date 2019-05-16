package ksaito.testJava11Gradle.userProperties;

import java.util.Properties;

public class TestXMLProperties extends BaseProperties{
    public TestXMLProperties() {
        super( "/xml.properties");
    }

    public Properties getProperties() {
        return super.getProperties();
    }
}
