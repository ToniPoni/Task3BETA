package com.epam.task3.service;


import com.epam.task3.bean.News;
import com.epam.task3.dao.DAOFactory;

import java.util.HashSet;

public class NewsService implements ServiceNews {

    @Override
    public HashSet<News> getNews(String tag) {
        return DAOFactory.getInstance().getTxtNewsDAO().getNews(tag);
    }

    @Override
    public HashSet<News> getNews(String tag1, String tag2) {
        return DAOFactory.getInstance().getTxtNewsDAO().getNews(tag1,tag2);
    }

    @Override
    public HashSet<News> getNews(News news) {
        return null;
    }
}
