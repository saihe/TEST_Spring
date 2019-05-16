package ksaito.testJava11Gradle2.userProperties;

import ksaito.testJava11Gradle2.userUtilities.SystemUtilities;

import java.util.Properties;

public class BaseProperties {
    private Properties prop = new Properties();
    public BaseProperties(String properyFilePath) {
        try {
            SystemUtilities.print("========プロパティ取得開始========");
            prop.load(this.getClass().getResourceAsStream(properyFilePath));
            prop.keySet().forEach(key -> SystemUtilities.print(key + "：" + prop.get(key)));
            SystemUtilities.print("========プロパティ取得終了========");
        } catch(Exception e) {
            e.printStackTrace();
            SystemUtilities.exit(9);
        }
    }

    public Properties getProperties() {
        return this.prop;
    }
}
