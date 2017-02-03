package com.epam.task3.controller.commands;


import com.epam.task3.bean.News;
import com.epam.task3.controller.Help;
import com.epam.task3.controller.commands.Command;
import com.epam.task3.service.NewsService;
import com.epam.task3.service.ServiceFactory;

public class AddNews implements Command {
    @Override
    public String execute(String request) {
        String category = null;
        String name = null;
        String creator = null;

        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {
            newsService.addNews(request);
        } catch (Exception e) {
            System.out.println("Wrong input");
            System.out.println(Help.getWrongInput());
            e.printStackTrace();
        }


        return response;
    }
}
