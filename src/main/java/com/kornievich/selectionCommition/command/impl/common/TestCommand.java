package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.PageConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestCommand implements BaseCommand {
    private static TestCommand instance = new TestCommand();

    public TestCommand() {
    }

    ;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
    @Override
    public String getPage(HttpServletRequest request) {

        String test=request.getParameter("sex");
        request.getSession().setAttribute("sexNow", test);
        return PageConstant.PAGE_PERSONAL_AREA;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static TestCommand getInstance() {
        return instance;
    }

}


