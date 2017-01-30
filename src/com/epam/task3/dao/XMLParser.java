package com.epam.task3.dao;


import com.epam.task3.bean.News;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;

public class XMLParser {

    public static HashSet<News> getNewsFromXML(String wayToFile) throws ParserConfigurationException, IOException, SAXException {
        HashSet<News> hashSet = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(wayToFile);
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
                        hashSet.add(new News(name.getAttribute("category"), name.getAttribute("name"),
                                name.getAttribute("creator")));

                    }
                }
            }
        }
        return hashSet;
    }
}
