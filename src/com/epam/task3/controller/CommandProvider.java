package com.epam.task3.controller;

import java.util.HashMap;
import java.util.Map;


public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.ADD_NEWS, new AddNews());
        repository.put(CommandName.GET_NEWS, new GetNews());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        commandName = CommandName.valueOf(name.toUpperCase());
        command = repository.get(commandName);

        return command;
    }
}
