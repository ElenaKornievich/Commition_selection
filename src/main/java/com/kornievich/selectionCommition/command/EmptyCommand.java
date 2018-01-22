package com.kornievich.selectionCommition.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmptyCommand implements BaseCommand {
    private static EmptyCommand instance = new EmptyCommand();
    public static EmptyCommand getInstance(){
        return instance;
    }

    private EmptyCommand(){};

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
