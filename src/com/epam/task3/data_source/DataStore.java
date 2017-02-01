package com.epam.task3.data_source;


import com.epam.task3.bean.News;
import com.epam.task3.dao.DAOFactory;

import java.io.IOException;
import java.util.HashSet;

public class DataStore {
    private static final DataStore instance = new DataStore();

    private HashSet<News> newsData = new HashSet<>();

    private DataStore(){
        fillNewsData();
    }

    public static DataStore getInstance() {
        return instance;
    }

    public HashSet<News> getNewsData() {
        return newsData;
    }
    public void addNews(News news) {
        newsData.add(news);
    }

    public void fillNewsData() {
        String pathToNewsDataFile = "C:\\Users\\Anton_Kuzmin\\IdeaProjects\\dataForTask3\\News.txt";
        try {
            newsData.addAll(DAOFactory.getInstance().getTxtParser().parseFile(pathToNewsDataFile)) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
