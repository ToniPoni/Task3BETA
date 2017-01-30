package com.epam.task3.dao;

import com.epam.task3.bean.News;

import java.util.List;

public class XMLNewsDAO implements NewsDao {
    @Override
    public void addNews(News news) {

    }

    @Override
    public List<News> getNews(String title) {
        return null;
    }

    @Override
    public List<News> getNews(String category, String title) {
        return null;
    }

    @Override
    public List<News> getNews(String category, String title, String creator) {
        return null;
    }
}
