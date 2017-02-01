package com.epam.task3.test;



import com.epam.task3.bean.News;
import com.epam.task3.dao.DAOFactory;
import com.epam.task3.data_source.DataStore;

import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args)  {
//        HashSet<News> news = new HashSet<>();
//        news.add(new News("Film","A","bruce"));
//        news.add(new News("Film","B","bruce LI"));
//        news.add(new News("Book","C","Anton"));
//
//        for (News n : news) {
//            if(n.getCategory().equals("A")) {
//                System.out.println(n);
//            }
//        }


//        for(News n : DataStore.getInstance().getNewsData()) {
//            System.out.println(n);
//        }

        System.out.println();

        for(News n : DAOFactory.getInstance().getTxtNewsDAO().getNews("Anton")) {
            System.out.println(n);
        }




    }
}
