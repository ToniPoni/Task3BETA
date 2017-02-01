package com.epam.task3.service;


import com.epam.task3.bean.News;
import com.epam.task3.dao.DAOFactory;
import com.epam.task3.dao.TXTNewsDAO;

import java.util.HashSet;

public class NewsService implements ServiceNews {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private TXTNewsDAO txtNewsDAO = daoFactory.getTxtNewsDAO();

    @Override
    public void addNews(News news) {
        txtNewsDAO.addNews(news);
    }

    @Override
    public HashSet<News> getNews(String tag) {
        return txtNewsDAO.getNews(tag);
    }

    @Override
    public HashSet<News> getNews(String tag1, String tag2) {
        return txtNewsDAO.getNews(tag1,tag2);
    }

    @Override
    public HashSet<News> getNews(News news) {
        return null;
    }
}
