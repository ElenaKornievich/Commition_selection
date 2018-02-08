package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.impl.admin.AdminPanelCommand;
import com.kornievich.selectionCommition.constant.PageConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class PersonalAreaCommand implements BaseCommand {
    private static PersonalAreaCommand instance = new PersonalAreaCommand();

    public PersonalAreaCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        return PageConstant.PAGE_PERSONAL_AREA;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.setAttribute("nav", 0);
        return PageConstant.PAGE_PERSONAL_AREA;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static PersonalAreaCommand getInstance() {
        return instance;
    }


}
