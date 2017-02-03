package com.epam.task3.view;


import com.epam.task3.controller.Controller;
import com.epam.task3.controller.exception.ControllerException;
import com.epam.task3.service.exception.ServiceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleCommunication {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, ControllerException, ServiceException {
        String request = ConsoleCommunication.reader.readLine();
        Controller controller = Controller.getInstance();
        controller.executeTask(request);
//
//            String str = " Book";
//        System.out.println(str.contains(" Anton "));
//        System.out.println(str.contains("Shoot"));
//        System.out.println(str.contains(" "));
//        System.out.println(str.contains("bla"));
//        System.out.println(str.contains("gagagagagagaga"));
//        for(News news : DataStore.getInstance().getNewsData()) {
//            System.out.println(news);
//        }

//        ServiceFactory serviceFactory = ServiceFactory.getInstance();
//        NewsService newsService = serviceFactory.getNewsService();
//
//        for(News n : newsService.getNews("Anton")) {
//            System.out.println(n);
//        }


    }
}
