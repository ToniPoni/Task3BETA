package com.epam.task3.service;

import com.epam.task3.bean.News;

import java.util.HashSet;

public interface ServiceNews {
    public void addNews(News news);
    public HashSet<News> getNews(String tag);
    public HashSet<News> getNews(String tag1, String tag2);
    public HashSet<News> getNews(News news);

}
