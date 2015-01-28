package com.apps.dylan.quiz.Util;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Dylan on 28/01/2015.
 */
public class XMLReader {

    private final static String easyQuestions = "EasyQuestions";

    public static NodeList getXMLNodesFromFile(String fileLocation){
        Document doc = openXMLFile(fileLocation);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName(easyQuestions);
        return nodeList;
    }

    public static Document openXMLFile(String fileLocation) {

        Document doc = null;

        try {
            File xmlFile = new File(fileLocation);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            doc = documentBuilder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return doc;
    }

}
