package com.epam.task3.dao;


public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final TXTNewsDAO txtNewsDAO = new TXTNewsDAO();
    private final TXTParser txtParser = new TXTParser();

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        return instance;
    }

    public TXTNewsDAO getTxtNewsDAO() {
        return txtNewsDAO;
    }
    public TXTParser getTxtParser() {
        return txtParser;
    }
}
