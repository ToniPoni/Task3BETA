package com.epam.task3.dao;


import com.epam.task3.bean.News;
import com.epam.task3.dao.exception.DAOException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

public class TXTFileWorkerDAO implements FileWorkable {
//    private String pathToNewsDataFile = "C:\\Users\\Anton_Kuzmin\\IdeaProjects\\dataForTask3\\News.doc";
    private String pathToNewsDataFile = "/home/anton/DataSourceForTask3.txt";

    @Override
    public HashSet<News> searchNewsInFIle(String request) throws DAOException {
        HashSet<News> news = new HashSet<>();
        if(request == null) {
            return news;
        } else {
            request = removePunct(request);
            request = request.toLowerCase();
            try {
                List<String> lines = Files.readAllLines(Paths.get(pathToNewsDataFile));
                String[] lineArr;
                String[] criteriaArray;
                for (String line : lines) {
                    if(!line.isEmpty()) {
                        lineArr = line.split(",");
                        criteriaArray = request.split(" ");
                        for(String crit : criteriaArray) {
                            if(lineArr[0].toLowerCase().equals(crit) || lineArr[1].toLowerCase().equals(crit) || lineArr[2].toLowerCase().equals(crit)) {
                                news.add(new News(lineArr[0], lineArr[1], lineArr[2]));
                            }
                        }
                    }
                }
                return news;

            } catch (IOException | ArrayIndexOutOfBoundsException e) {
                throw new DAOException("Sorry we have technical problems");
            }

        }
    }

    @Override
    public void addItem(String request) throws DAOException {
        try {
            FileWriter writer = new FileWriter(pathToNewsDataFile, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write("\n" + request);
            bufferWriter.close();
        } catch (IOException e) {
            throw new DAOException("Sorry we have technical problems.");
        }

    }

    private String removePunct(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isSpaceChar(c)) {
                result.append(c);
            } else {
                result.append(" ");
            }
        }
        return result.toString();
    }


    public String getPathToNewsDataFile() {
        return pathToNewsDataFile;
    }

    public void setPathToNewsDataFile(String pathToNewsDataFile) {
        this.pathToNewsDataFile = pathToNewsDataFile;
    }
}
