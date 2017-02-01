package com.epam.task3.controller;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    private static final Controller instance = new Controller();

    private Controller(){}

    public static Controller getInstance() {
        return instance;
    }


    private final char paramDelimeter = ' ';


    public String executeTask(String request){
        String commandName;
        Command executionCommand;
        commandName = request.substring(0, request.indexOf(paramDelimeter));
        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(request);
        return response;
    }
}
