package com.kornievich.selectionCommition.command.impl.common;

import com.kornievich.selectionCommition.command.BaseCommand;
import com.kornievich.selectionCommition.constant.AttributeConstant;
import com.kornievich.selectionCommition.constant.PageConstant;
import com.kornievich.selectionCommition.constant.ParameterConstant;
import com.kornievich.selectionCommition.entity.EntrantInQueueModal;
import com.kornievich.selectionCommition.exception.DAOException;
import com.kornievich.selectionCommition.service.RequestService;
import com.kornievich.selectionCommition.service.SpecialityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class QueueCommand implements BaseCommand {

    static final Logger LOGGER = LogManager.getLogger(QueueCommand.class);

    private static QueueCommand instance = new QueueCommand();

    private QueueCommand() {}

    public static QueueCommand getInstance() {
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("The execute() method is called");
        int specialityId = Integer.parseInt(request.getParameter(ParameterConstant.PARAMETER_SPECIALITY_ID));
        ArrayList<EntrantInQueueModal> queue = null;
        try {
            queue = RequestService.getInstance().allEntrantsScoreBySpecialty(specialityId);
            request.setAttribute(AttributeConstant.ATTRIBUTE_SPECIALITY,
                    SpecialityService.getInstance().findSpecialityById(specialityId));
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't calculate all entrants scope by speciality with such input id. " + e);
        }
        if (queue != null) {
            request.setAttribute(AttributeConstant.ATTRIBUTE_QUEUE, queue);
            return PageConstant.PAGE_TURN_FOR_SPECIALITY;
        }
        return PageConstant.PAGE_QUEUE_IS_NULL;
    }

    @Override
    public String getPage(HttpServletRequest request) {
        LOGGER.info("The getPage() method is called");
        try {
            request.setAttribute(AttributeConstant.ATTRIBUTE_SPECIALITIES,
                    SpecialityService.getInstance().readAllSpecialities());
        } catch (DAOException e) {
            e.printStackTrace();
            LOGGER.error("Can't read all specialities. " + e);
        }
        return PageConstant.PAGE_QUEUE;

    }
}
