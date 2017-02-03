package com.epam.task3.dao;


import com.epam.task3.bean.News;
import com.epam.task3.dao.exception.DAOException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

public class TXTFileWorkerDAO implements FileWorkable {
    private String pathToNewsDataFile = "C:\\Users\\Anton_Kuzmin\\IdeaProjects\\dataForTask3\\News.doc";

    @Override
    public HashSet<News> searchNewsInFIle(String criteria) throws IOException, DAOException {
        HashSet<News> news = new HashSet<>();
        System.out.println("do" + criteria);
        criteria = removePunct(criteria);
        System.out.println("posle" + criteria);
        criteria = criteria.toLowerCase();
        List<String> lines = Files.readAllLines(Paths.get(pathToNewsDataFile));
        String[] lineArr;
        String[] criteriaArray;
        for (String line : lines) {
            lineArr = line.split(",");
            if(lineArr.length < 3) {
                throw new DAOException("Array out of bound exception");
            }
            criteriaArray = criteria.split(" ");
            for(String crit : criteriaArray) {
                if(lineArr[0].toLowerCase().equals(crit) || lineArr[1].toLowerCase().equals(crit) || lineArr[2].toLowerCase().equals(crit)) {
                    news.add(new News(lineArr[0], lineArr[1], lineArr[2]));
                }
//                if(line.toLowerCase().contains(crit)) {
//                    news.add(new News(lineArr[0], lineArr[1], lineArr[2]));
//                }
            }

        }

        return news;

    }

    @Override
    public void addItem(String request) {
        try {
            FileWriter writer = new FileWriter(pathToNewsDataFile, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            //bufferWriter.newLine();
            bufferWriter.write("\n" + request);
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private String removePunct(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isSpaceChar(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

}
