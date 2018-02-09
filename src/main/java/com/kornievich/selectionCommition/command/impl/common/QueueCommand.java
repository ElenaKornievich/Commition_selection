package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.command.impl.admin.ChangeEntrantCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.dao.impl.RequestsDAO;
import com.kornievich.selectionCommition.entity.EntrantInQueueModal;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.SpecialityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class QueueCommand implements BaseCommand {
    static final Logger LOGGER = LogManager.getLogger(QueueCommand.class);
    private static QueueCommand instance = new QueueCommand();

    public QueueCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int specialityId = Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_ID));
        RequestsDAO requestsDAO = new RequestsDAO();
        ArrayList<EntrantInQueueModal> queue = null;
        try {
            queue = requestsDAO.allEntrantsScoreBySpecialty(specialityId);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        if(queue!=null){
        request.setAttribute(AttributeConstant.ATTRIBUTE_QUEUE, queue);
        return PageConstant.PAGE_TURN_FOR_SPECIALITY;
        }
        return PageConstant.PAGE_QUEUE_IS_NULL;
    }
    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_SPECIALITIES, SpecialityService.getInstance().readAllSpecialities());
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return PageConstant.PAGE_QUEUE;

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static QueueCommand getInstance() {
        return instance;
    }

}
