package com.epam.task3.dao;

import com.epam.task3.bean.News;
import com.epam.task3.dao.exception.DAOException;

import java.io.IOException;
import java.util.HashSet;

public interface Parsable {
    public HashSet<News> parseFile(String wayToFile) throws Exception;
}
