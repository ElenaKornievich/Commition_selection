<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<head>
    <c:set var="language"
           value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
           scope="session"/>
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="text"/>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="/js/validation.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="/css/style.css" type="text/css" media="screen"></head>
<link rel="stylesheet" type="text/css" href="/SemanticUI/semantic.min.css">
<script
        src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous"></script>
<script src="/SemanticUI/semantic.min.js"></script>
<body>

<div class="ui attached stackable menu">
    <div class="ui container">

        <a href="../index.jsp" class="item">
            <i class="home icon"></i> <fmt:message key="header.button.main"/>
        </a>
        <c:set var = "personalArea" scope = "session" value = "${role}"/>
        <c:set var = "adminPanel" scope = "session" value = "admin"/>
        <c:set var = "personalArea" scope = "session" value = "entrant"/>
        <c:choose>
        <c:when test="${role == adminPanel}">
        <a href="controller?command=adminPanel" class="item">
            <fmt:message key="header.button.adminPanel"/></a>
        </c:when>
        <c:when test="${role == personalArea}">
        <a href="controller?command=personalArea" class="item">
            <fmt:message key="header.button.personalArea"/></a>
        </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
        <a href="controller?command=queue" class="item">
            <fmt:message key="header.button.queue"/>
        </a>
        <a href="controller?command=mainFaculty" class="item">
            <fmt:message key="header.button.mainFaculty"/>
        </a>
        <a href="controller?command=contact" class="item">
            <fmt:message key="header.button.contact"/>
        </a>
        <c:set var = "user" scope = "session" value = "${user}"/>
        <c:if test="${empty user}"><a href="controller?command=login" class="item"><fmt:message key="header.button.login"/></a>

        <a href="controller?command=registration" class="item"><fmt:message key="header.button.registration"/></a></c:if>
        <c:if test="${not empty user}"><a href="controller?command=logout" class="item"><fmt:message key="header.button.logout"/></a></c:if>

    </div>
</div>


