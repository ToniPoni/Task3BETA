package com.epam.task3.controller;

import com.epam.task3.controller.commands.CommandName;

public class Help {
    private static String wrongInput = "Please use only supported commands : \n" +
            CommandName.ADD_NEWS + "\n" +
            CommandName.GET_NEWS + "\n" +
            "request must look like : Command-Category,Name,Creator";

    public static String getWrongInput() {
        return wrongInput;
    }
}
