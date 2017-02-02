package com.epam.task3.dao;

import com.epam.task3.bean.News;
import com.epam.task3.dao.exception.DAOException;
import com.epam.task3.data_source.DataStore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TXTNewsDAO implements NewsDAO {
    @Override
    public void addNews(News news)  {
            DataStore.getInstance().addNews(news);
    }

    @Override
    public HashSet<News> getNews(String tag) {
        HashSet<News> buffSet = new HashSet<>();
        for(News news : DataStore.getInstance().getNewsData()) {
            if(news.getCreator().equals(tag) || news.getName().equals(tag) || news.getCreator().equals(tag)) {
                buffSet.add(news);
            }
        }
        return buffSet;
    }

    @Override
    public HashSet<News> getNews(String tag1, String tag2) {
        HashSet<News> buffSetByFirstTag = getNews(tag1);
        HashSet<News> buffSet = new HashSet<>();
        for(News news : buffSetByFirstTag) {
            if(news.getCreator().equals(tag2) || news.getName().equals(tag2) || news.getCreator().equals(tag2)) {
                buffSet.add(news);
            }
        }
        return buffSet;
    }


    @Override
    public News getNews(News news) {
        if(DataStore.getInstance().getNewsData().contains(news)) {
            return news;
        } else {
            return null;
        }

    }


}
