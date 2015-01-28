package com.apps.dylan.quiz;

import com.apps.dylan.quiz.Util.XMLReader;

import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Dylan on 28/01/2015.
 */
public class Startup {

    private static Startup instance = new Startup();

    private static final String easyQuestionsXML = "res//xml//easyquestions.xml";

    public static Startup getInstance() { return instance; }
    public static NodeList getEasyQuestionsNodeList() { return easyQuestionsNodeList; }

    private static NodeList easyQuestionsNodeList = null;

    public void Initialise(XmlPullParser xmlPullParser){
        GetQuestions(xmlPullParser);
    }

    public void GetQuestions(XmlPullParser xmlPullParser){
        XMLReader.getXMLNodesFromFile(xmlPullParser);
    }



}
