package com.epam.task3.dao;

import com.epam.task3.bean.News;

import java.io.IOException;
import java.util.HashSet;

public interface Parsable {
    public HashSet<News> parseFile(String wayToFile) throws IOException;
}
