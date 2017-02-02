package com.epam.task3.dao;


import com.epam.task3.bean.News;
import com.epam.task3.dao.exception.DAOException;

import java.util.HashSet;
import java.util.List;

public interface NewsDAO {
    void addNews(News news) ;
    HashSet<News> getNews(String tag) ;
    HashSet<News> getNews(String tag1,String tag2)  ;
    News getNews(News news)  ;


}
