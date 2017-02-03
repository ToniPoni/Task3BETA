package com.epam.task3.dao;

import com.epam.task3.bean.News;
import com.epam.task3.dao.exception.DAOException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

public class TXTParserDAO implements Parsable {

    @Override
    public HashSet<News> parseFile (String wayToFile) throws Exception {
        HashSet<News> news = new HashSet<>();

            List<String> lines = Files.readAllLines(Paths.get(wayToFile));
            String[] arr;
            for (String line : lines) {
                arr = line.split(",");
                if(arr.length != 3) {
                    throw new Exception("Invalid reading from file");
                }
                news.add(new News(arr[0], arr[1], arr[2]));
            }


        return news;
    }



}
