package ksaito.testJava11Gradle.userClasses;

import ksaito.testJava11Gradle.userBeans.FoodBean;
import ksaito.testJava11Gradle.userProperties.TestXMLProperties;
import ksaito.testJava11Gradle.userUtilities.SystemUtilities;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class TestDOM4J {
    public void run() {
        TestXMLProperties prop = new TestXMLProperties();
        SAXReader saxReader = new SAXReader(false);
        List<FoodBean> foodList = new ArrayList<FoodBean>();
        try{
            Document document = saxReader.read(
                    prop.getProperties().getProperty("test.xml.input.dirPath")
                            + "/"
                            + prop.getProperties().getProperty("test.xml.input.fileName")
            );
            List nodes = document.selectNodes("/foods/food[@id='1']");
            for (Object object : nodes) {
                if (object instanceof Element) {
                    FoodBean foodBean = new FoodBean();
                    foodBean.setName(((Element)object).element("name").getText());
                    foodBean.setColor(((Element)object).element("color").getText());
                    foodList.add(foodBean);
                    SystemUtilities.print(foodBean.toString());
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            SystemUtilities.exit(9);
        }
    }
}
