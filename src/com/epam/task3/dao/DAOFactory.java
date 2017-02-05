package com.epam.task3.dao;


public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final TXTFileWorkerDAO txtFileWorkerDAO = new TXTFileWorkerDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        return instance;
    }

    public TXTFileWorkerDAO getTxtFileWorkerDAO() {
        return txtFileWorkerDAO;
    }

}
