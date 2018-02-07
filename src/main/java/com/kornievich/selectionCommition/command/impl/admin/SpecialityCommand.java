package com.kornievich.selectionCommition.command.impl.admin;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.service.SpecialityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpecialityCommand implements BaseCommand{
    //  private static Logger logger = Logger.getLogger(LoginCommand.class);

    private static SpecialityCommand instance = new SpecialityCommand();

    public SpecialityCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int specialityId =Integer.valueOf(request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_ID));
        SpecialityService.getInstance().delete(specialityId);
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,11);
        return PageConstant.PAGE_ADMIN_PANEL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        request.setAttribute(AttributeConstant.ATTRIBUTE_LIST_SPECIALITY, SpecialityService.getInstance().readAll());
        request.setAttribute(AttributeConstant.ATTRIBUTE_NAVIGATION,13);
        return PageConstant.PAGE_ADMIN_PANEL;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static SpecialityCommand getInstance() {
        return instance;
    }

}


