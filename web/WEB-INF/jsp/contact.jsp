<%--
  Created by IntelliJ IDEA.
  User: Fox
  Date: 29.01.2018
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml">


<%@include file="header.jsp"%>

<h1>Тут все контакты и ссылки (посмотреть на мехматовские)</h1>
<table>
    <c:forEach var = "i" items="${entrant}">
        : <c:out value = "${i}"/>
    </c:forEach>
</table>
</body>
</html>
