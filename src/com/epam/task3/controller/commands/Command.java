package com.epam.task3.controller.commands;

import com.epam.task3.service.exception.ServiceException;

public interface Command {
    public String execute(String request) ;
}
