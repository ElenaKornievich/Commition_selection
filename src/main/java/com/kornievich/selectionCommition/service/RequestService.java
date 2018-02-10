package com.kornievich.selectionCommition.service;

import com.kornievich.selectionCommition.dao.impl.RequestDAO;
import com.kornievich.selectionCommition.entity.EntrantInQueueModal;
import com.kornievich.selectionCommition.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class RequestService {
    static final Logger LOGGER = LogManager.getLogger(RequestService.class);

    private static RequestService instance;
    private RequestDAO requestDAO;
    private RequestService() {
        requestDAO =new RequestDAO();
    }


    public static RequestService getInstance() {
        LOGGER.info("The getInstance() method is called");
        if(instance==null){
            instance= new RequestService();
        }
        return instance;
    }
    public ArrayList<EntrantInQueueModal> allEntrantsScoreBySpecialty(int idSpecialty) throws DAOException {
        LOGGER.info("The allEntrantsScoreBySpecialty() method is called");
        return requestDAO.allEntrantsScoreBySpecialty(idSpecialty);
    }


}
