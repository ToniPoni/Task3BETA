package com.epam.task3.controller;

import com.epam.task3.controller.commands.Command;
import com.epam.task3.controller.commands.CommandProvider;
import com.epam.task3.controller.exception.ControllerException;
import com.epam.task3.service.exception.ServiceException;

import java.io.IOException;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    private static final Controller instance = new Controller();

    private Controller() {
    }

    public static Controller getInstance() {
        return instance;
    }


    private final String paramDelimeter = "-";


    public String executeTask(String request) throws IOException, ControllerException, ServiceException {

        String commandName;
        Command executionCommand;
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //проблема в том что нужно как то погасить Exception возникающий здесь.
        commandName = request.substring(0, request.indexOf(paramDelimeter));
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        executionCommand = provider.getCommand(commandName);
        String response;
        request = request.replace(commandName, "");
        request = request.replace(paramDelimeter, "");
        response = executionCommand.execute(request);

        return response;
    }

    public String takeCommand(String request) {
        String commandName = request.substring(0, request.indexOf(paramDelimeter));
        return commandName;
    }
}
