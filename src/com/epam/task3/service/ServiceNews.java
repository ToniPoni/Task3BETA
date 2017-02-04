package com.epam.task3.service;

import com.epam.task3.bean.News;
import com.epam.task3.service.exception.ServiceException;

import java.io.IOException;
import java.util.HashSet;

public interface ServiceNews {
    public void addNews(String request) ;

    public HashSet<News> getNews(String tag) throws IOException, ServiceException;

}
