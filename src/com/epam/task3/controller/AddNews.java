package com.epam.task3.controller;


import com.epam.task3.bean.News;
import com.epam.task3.service.NewsService;
import com.epam.task3.service.ServiceFactory;

public class AddNews implements Command {
    @Override
    public String execute(String request) {
        String category = null;
        String name = null;
        String creator = null;

        String response = null;

        String [] tags = request.split(" ");

        category = tags[1];
        name = tags[2];
        creator = tags[3];

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {
            newsService.addNews(new News(category, name, creator));
        } catch (Exception e) {
            System.out.println("Wrong input");
        }


        return response;
    }
}
