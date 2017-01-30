package com.epam.task3.dao;


import com.epam.task3.bean.News;

public interface NewsDao {
    void addNews(News news);
    void getNews(String title);

}
