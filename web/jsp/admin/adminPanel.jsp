<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ctg" uri="/WEB-INF/tld/custom.tld" %>

<html>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<link rel="stylesheet" type="text/css" href="/SemanticUI/semantic.min.css">

<script
        src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous"></script>
<script src="/SemanticUI/semantic.min.js"></script>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/validation.js"></script>
<link type="text/css" rel="stylesheet" href="/css/adminPanel.css">

    <%@include file="../header.jsp"%>

<div class="nav">
<div class="ui vertical menu">
        <a class="teal item active" href="controller?command=changeAdmin">
    <fmt:message key="admin.button.changeAdmin"/>

    </a>
    <a class="item" href="controller?command=adminInformation">
        <fmt:message key="admin.button.adminInformation"/>

    </a>
    <a class="item" href="controller?command=changeButton">
        <fmt:message key="admin.button.changeButton"/>

    </a>
    </a>
    <a class="item" href="controller?command=speciality">
        <fmt:message key="admin.button.speciality"/>

    </a>

    <a class="item" href="controller?command=subject" >
        <fmt:message key="admin.button.subject"/>

    </a>

    <a class="item" href="controller?command=faculty">
        <fmt:message key="admin.button.faculty"/>

    </a>

    <a class="item" href="controller?command=createAdmin">
        <fmt:message key="admin.button.createAdmin"/>
    </a>

</div>
</div>


<div class="content">
        <c:set var = "nav" scope = "page" value = "${nav}"/>
        <c:choose>
            <c:when test="${nav == 1}">
                <%@include file="changeEntrant.jsp"%>
            </c:when>
            <c:when test="${nav == 2}">
                <%@include file="changeAdminInformation.jsp"%>
            </c:when>
            <c:when test="${nav == 3}">
                <%@include file="adminInformation.jsp"%>
            </c:when>
            <c:when test="${nav == 4}">
                <%@include file="pointCTEntrant.jsp"%>
            </c:when>
            <c:when test="${nav == 5}">
                <%@include file="createAdmin.jsp"%>
            </c:when>
            <c:when test="${nav == 6}">
                <%@include file="createFaculty.jsp"%>
            </c:when>
            <c:when test="${nav == 7}">
                <%@include file="createSubject.jsp"%>
            </c:when>
            <c:when test="${nav == 8}">
                <%@include file="createSpeciality.jsp"%>
            </c:when>
            <c:when test="${nav == 9}">
                <%@include file="changeFaculty.jsp"%>
            </c:when>
            <c:when test="${nav == 10}">
                <%@include file="changeSubject.jsp"%>
            </c:when>
            <c:when test="${nav == 12}">
                <%@include file="faculties.jsp"%>
            </c:when>
            <c:when test="${nav == 11}">
                <%@include file="changeSpeciality.jsp"%>
            </c:when>
            <c:when test="${nav == 13}">
                <%@include file="specialities.jsp"%>
            </c:when>
            <c:when test="${nav == 14}">
                <%@include file="subjects.jsp"%>
            </c:when>
            <c:otherwise>
                <h3><ctg:role role="${role}"/></h3>
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>
