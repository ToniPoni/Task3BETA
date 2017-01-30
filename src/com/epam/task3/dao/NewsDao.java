package com.epam.task3.dao;


import com.epam.task3.bean.News;

import java.util.List;

public interface NewsDao {
    void addNews(News news);
    List<News> getNews(String title);
    List<News> getNews(String category, String title);
    List<News> getNews(String category, String title, String creator);


}
