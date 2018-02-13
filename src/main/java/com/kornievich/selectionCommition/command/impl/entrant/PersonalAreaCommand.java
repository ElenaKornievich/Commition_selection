package com.kornievich.selectionCommition.command.impl.entrant;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.PageConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonalAreaCommand implements BaseCommand {

    private static final Logger LOGGER = LogManager.getLogger(PersonalAreaCommand.class);

    private static PersonalAreaCommand instance = new PersonalAreaCommand();

    private PersonalAreaCommand() {}

    public static PersonalAreaCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        return PageConstant.PAGE_PERSONAL_AREA;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        request.setAttribute("nav", 0);
        return PageConstant.PAGE_PERSONAL_AREA;
    }
}
