package com.kornievich.selectionCommition.command;

import com.kornievich.selectionCommition.command.impl.admin.ChangeEntrantCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmptyCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(EmptyCommand.class);
    private static EmptyCommand instance = new EmptyCommand();
    public static EmptyCommand getInstance(){
        return instance;
    }

    private EmptyCommand(){}

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        return null;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        return null;
    }
}
