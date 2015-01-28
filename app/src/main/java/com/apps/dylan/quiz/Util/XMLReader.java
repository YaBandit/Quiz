package com.apps.dylan.quiz.Util;

import android.content.Context;
import android.content.res.Resources;

import com.apps.dylan.quiz.R;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Dylan on 28/01/2015.
 */
public class XMLReader {

    private final static String easyQuestions = "EasyQuestions";

    public static void getXMLNodesFromFile(XmlPullParser xmlPullParser){

        ArrayList<String> items=new ArrayList<String>();

        try {
            while (xmlPullParser.getEventType()!=XmlPullParser.END_DOCUMENT) {
                if (xmlPullParser.getEventType()==XmlPullParser.START_TAG) {
                    if (xmlPullParser.getName().equals("word")) {
                        items.add(xmlPullParser.getAttributeValue(0));
                    }
                }
                xmlPullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**Document doc = openXMLFile(fileLocation);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName(easyQuestions);
        return nodeList;**/
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
