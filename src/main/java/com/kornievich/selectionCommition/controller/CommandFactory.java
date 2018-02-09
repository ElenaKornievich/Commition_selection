package com.kornievich.selectionCommition.controller;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.CommandEnum;
import com.kornievich.selectionCommition.command.EmptyCommand;
import com.kornievich.selectionCommition.command.impl.common.RegistrationCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {

    static final Logger LOGGER = LogManager.getLogger(CommandFactory.class);
    public BaseCommand defineCommand(HttpServletRequest request){
        LOGGER.info("The defineCommand() method is called");
        BaseCommand command = EmptyCommand.getInstance();
        String action = request.getParameter("command");
       // logger.info("Processing command: " + action);
        if(action == null || action.isEmpty()){
            System.out.println("пустая команда");
             return command;
        }

        try{
           // request.setAttribute("login","elena");
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            command = currentEnum.getCurrentCommand();
            if(command==null){
                System.out.println("пестая команда");
            }
        } catch(IllegalArgumentException e){
            System.out.println("ppp[2]");
            // request.setAttribute(AttributeConst.ATTR_ERROR_MESSAGE, MessageConst.MESSAGE_WRONG_ACTION);
        }
        return command;
    }
}
