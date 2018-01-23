package com.kornievich.selectionCommition.command;

import com.kornievich.selectionCommition.entity.User;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseCommand {
    String execute(HttpServletRequest request, HttpServletResponse response);
    String getPage(HttpServletRequest request);

}