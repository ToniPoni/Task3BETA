package com.epam.task3.controller.commands;

import com.epam.task3.bean.News;
import com.epam.task3.controller.commands.Command;
import com.epam.task3.service.NewsService;
import com.epam.task3.service.ServiceFactory;
import com.epam.task3.service.exception.ServiceException;

import java.io.IOException;


public class GetNews implements Command {
    @Override
    public String execute(String request) throws IOException, ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();



        for(News news : newsService.getNews(request)) {
            //System.out.println("Hello");
            System.out.println(news);
        }

        System.out.println(request.length());


        return null;
    }
}
