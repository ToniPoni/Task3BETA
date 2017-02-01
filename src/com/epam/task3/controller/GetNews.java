package com.epam.task3.controller;

import com.epam.task3.bean.News;
import com.epam.task3.service.NewsService;
import com.epam.task3.service.ServiceFactory;

/**
 * Created by Anton_Kuzmin on 2/1/2017.
 */
public class GetNews implements Command {
    @Override
    public String execute(String request) {

        String [] tags = request.split(" ");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();


        if(tags.length - 1 == 1) {
            for(News news : newsService.getNews(tags[1])) {
                System.out.println(news);
            }
        } else if(tags.length - 1 == 2) {
            for(News news : newsService.getNews(tags[1], tags[2])) {
                System.out.println(news);
            }
        }
        System.out.println(request.length());


        return null;
    }
}
