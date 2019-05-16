package ksaito.testJava11Gradle.userClasses;


import ksaito.testJava11Gradle.userProperties.TestXMLProperties;
import ksaito.testJava11Gradle.userUtilities.SystemUtilities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;

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
            NodeList nodeList = element.getElementsByTagName(
                    prop.getProperties().getProperty("test.xml.element.name")
            );
            String id = "1";
            SystemUtilities.print("取得したい[food]の[id]：" + id);
            Node node = getNode(nodeList, id);
            SystemUtilities.print("ID：" + node.getAttributes().getNamedItem("id").getNodeValue());
            SystemUtilities.print("ノード名：" + node.getNodeName());
            SystemUtilities.print("名前：" + getNode(node, "name").getTextContent());
            SystemUtilities.print("色：" + getNode(node, "color").getTextContent());

        } catch(Exception e) {
            e.printStackTrace();
            SystemUtilities.exit(9);
        }
    }

    private Node getNode (NodeList nodeList, String id) {
            for(int i = 0; i < nodeList.getLength(); i++) {
                NodeList children = nodeList.item(i).getChildNodes();
                for(int j = 0; j < children.getLength(); j++) {
                    if(id.equals(nodeList.item(i).getAttributes().getNamedItem("id").getNodeValue())) {
                        return nodeList.item(i);
                    }
                }
            }

        return null;
    }

    private Node getNode(Node node, String elementName) {
        NodeList nodeList = node.getChildNodes();
        for(int i = 0; i < nodeList.getLength(); i++) {
            if(elementName.equals(nodeList.item(i).getNodeName())) {
                return nodeList.item(i);
            }
        }

        return null;
    }
}
