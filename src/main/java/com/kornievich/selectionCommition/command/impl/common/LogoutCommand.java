package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements BaseCommand {
    private static LogoutCommand instance = new LogoutCommand();

    private LogoutCommand(){};

    public static LogoutCommand getInstance(){
        return instance;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        return null;
    }
}
