package com.epam.task3.service;


import com.epam.task3.bean.News;
import com.epam.task3.dao.DAOFactory;
import com.epam.task3.dao.TXTFileWorkerDAO;
import com.epam.task3.dao.exception.DAOException;
import com.epam.task3.service.exception.ServiceException;

import java.util.HashSet;

public class NewsService implements ServiceNews {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private TXTFileWorkerDAO txtFileWorkerDAO = daoFactory.getTxtFileWorkerDAO();

    @Override
    public void addNews(String request) throws ServiceException {
        try {
            txtFileWorkerDAO.addItem(request);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public HashSet<News> getNews(String request) throws ServiceException {
        try {
            return txtFileWorkerDAO.searchNewsInFIle(request);
        } catch ( DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
