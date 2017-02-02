package com.epam.task3.data_source;


import com.epam.task3.bean.News;
import com.epam.task3.dao.exception.DAOException;
import com.epam.task3.dao.DAOFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashSet;

public class DataStore {
    private static final DataStore instance = new DataStore();
    private String pathToNewsDataFile = "C:\\Users\\Anton_Kuzmin\\IdeaProjects\\dataForTask3\\News.doc";
    private HashSet<News> newsData = new HashSet<>();

    private DataStore() {
        fillNewsData();
    }

    public static DataStore getInstance() {
        return instance;
    }

    public HashSet<News> getNewsData() {
        return newsData;
    }

    public void addNews(News news)  {
        newsData.add(news);
        writeNewsToFile(news);
    }

    public void writeNewsToFile(News news)  {
        String readyNews = news.getCategory() + "," + news.getName() + "," + news.getCreator();

        try {
            FileWriter writer = new FileWriter(pathToNewsDataFile, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(readyNews);
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void fillNewsData()  {
        try {
            newsData.addAll(DAOFactory.getInstance().getTxtParser().parseFile(pathToNewsDataFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
