package ksaito.testJava11Gradle.userClasses;


import ksaito.testJava11Gradle.userProperties.TestXMLProperties;
import ksaito.testJava11Gradle.userUtilities.SystemUtilities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class TestXML {
    public void run01() {
        TestXMLProperties prop = new TestXMLProperties();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(
                    prop.getProperties().getProperty("test.xml.input.dirPath")
                     + "/"
                     + prop.getProperties().getProperty("test.xml.input.fileName")
            );
            Element element = document.getDocumentElement();
            SystemUtilities.print(element.getTagName());
            NodeList nodeList = element.getElementsByTagName("user");
            for(int i = 0; i < nodeList.getLength(); i++) {
                SystemUtilities.print(nodeList.item(i).getNodeName());
                SystemUtilities.print(nodeList.item(i).getTextContent());
                NodeList children = nodeList.item(i).getChildNodes();
                for(int j = 0; j < children.getLength(); j++) {
                    SystemUtilities.print(nodeList.item(i).getNodeName());
                    SystemUtilities.print(nodeList.item(i).getTextContent());
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
            SystemUtilities.exit(9);
        }
    }
}
