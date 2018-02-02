package com.kornievich.selectionCommition.command;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "DefaultLocaleFilter", urlPatterns = {"/app/*"})
public class DefaultLocaleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        req.getSession().setAttribute("language", "ru");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}