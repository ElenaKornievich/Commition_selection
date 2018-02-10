<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link type="text/css" rel="stylesheet" href="/css/adminPanel.css"><link rel="stylesheet" type="text/css" href="/SemanticUI/semantic.min.css">
<script
        src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous"></script>
<script src="/SemanticUI/semantic.min.js"></script>
<script src="/js/validation.js"></script>
<script src="/js/jquery-3.2.1.min.js"></script>
<%@include file="../header.jsp" %>


<div class="nav">
    <div class="ui vertical menu">
        <a class="teal item active" href="controller?command=about">Личная информация</a>

        <a class="teal item" href="controller?command=change">Редактировать личную информацию</a>

        <a class="teal item" href="controller?command=changeEntrantSpeciality">Изменить специальность</a>



    </div>
</div>
<div>

    <c:set var="nav" scope="page" value="${nav}"/>
    <c:choose>
        <c:when test="${nav == 1}">
            <%@include file="formChangePersonalInformation.jsp" %>
        </c:when>
        <c:when test="${nav == 2}">
            <%@include file="changeSpecialty.jsp" %>
        </c:when>
        <c:when test="${nav == 3}">
            <%@include file="aboutMe.jsp" %>
        </c:when>
        <c:otherwise>
            <h3><ctg:role role="${role}"/></h3>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
