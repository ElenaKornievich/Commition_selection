package com.kornievich.selectionCommition.command;

import com.kornievich.selectionCommition.entity.User;
import com.kornievich.selectionCommition.exception.CommandException;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseCommand {
    String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
    String getPage(HttpServletRequest request);

}