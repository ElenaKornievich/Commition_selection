package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.impl.admin.ChangeEntrantCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(LogoutCommand.class);
    private static LogoutCommand instance = new LogoutCommand();

    private LogoutCommand(){};

    public static LogoutCommand getInstance(){
        return instance;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        return null;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        if(request.getSession().getAttribute(AttributeConstant.ATTRIBUTE_ID)!=null){
            HttpSession session=request.getSession();
            session.invalidate();
            return PageConstant.PAGE_INDEX;
        }
        return null;
    }
}
