package com.epam.task3.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        /*DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("data.xml");
        NodeList newsList = doc.getElementsByTagName("newsID");
        for(int i = 0; i < newsList.getLength(); i++) {
            Node p  = newsList.item(i);
            if(p.getNodeType() == Node.ELEMENT_NODE) {
                Element news = (Element) p;
                String id = news.getAttribute("id");
                NodeList nameFilmList = news.getChildNodes();
                    for(int j = 0; j < nameFilmList.getLength(); j++) {
                        Node n = nameFilmList.item(j);
                        if(n.getNodeType() == Node.ELEMENT_NODE) {
                            Element name = (Element) n;
                            System.out.println(id + " " + name);
                        }
                    }
            }
        }*/

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("data.xml");
        NodeList newsList = doc.getElementsByTagName("news");
        for(int i = 0; i < newsList.getLength(); i++) {
            Node p  = newsList.item(i);
            if(p.getNodeType() == Node.ELEMENT_NODE) {
                Element news = (Element) p;
                String id = news.getAttribute("id");
                NodeList nameFilmList = news.getChildNodes();
                for(int j = 0; j < nameFilmList.getLength(); j++) {
                    Node n = nameFilmList.item(j);
                    if(n.getNodeType() == Node.ELEMENT_NODE) {
                        Element name = (Element) n;
                        System.out.println(id + " " + name.getTextContent());
                    }
                }
            }
        }
    }
}
