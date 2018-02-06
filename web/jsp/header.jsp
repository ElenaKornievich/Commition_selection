
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <c:set var="language"
           value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
           scope="page"/>
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="text"/>
    <form >
        <select id="language" name="language" onchange="submit()">
            <option value="ru" ${language == 'ru' ? 'selected' : ''}>RU</option>
            <option value="en" ${language == 'en' ? 'selected' : ''}>EN</option>
        </select>
    </form>
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
        <a class="item">
            <i class="home icon"></i> Home
        </a>
        <a href="controller?command=main" class="item">
            <i class="grid layout icon"></i> Главная
        </a>
        <c:set var = "personalArea" scope = "session" value = "${role}"/>
        <c:set var = "adminPanel" scope = "session" value = "admin"/>
        <c:set var = "personalArea" scope = "session" value = "entrant"/>
        <c:choose>
        <c:when test="${role == adminPanel}">
        <a href="controller?command=adminPanel" class="item">
            <i class="mail icon"></i> Панель администратора</a>
        </c:when>
        <c:when test="${role == personalArea}">
        <a href="controller?command=personalArea" class="item">
            <i class="mail icon"></i> Личный кабинет</a>
        </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
      <!--  <a href="controller?command=personalArea" class="item">
            <i class="mail icon"></i> Личный кабинет
        </a>-->
        <a href="controller?command=queue" class="item">
            Очередь
        </a>
        <a href="controller?command=faculty" class="item">
            О Факультетах
        </a>
        <a href="controller?command=contact" class="item">
            Контакты
        </a>
        <c:set var = "user" scope = "session" value = "${user}"/>
        <c:if test="${empty user}"><a href="controller?command=login" class="item">Вход</a>

        <a href="controller?command=registration" class="item">Регистрация</a></c:if>
        <c:if test="${not empty user}"><a href="controller?command=logout" class="item">Выход</a></c:if>
        <div class="ui simple dropdown item">
            More
            <i class="dropdown icon"></i>
            <div class="menu">
                <a class="item"><i class="edit icon"></i> Edit Profile</a>
                <a class="item"><i class="globe icon"></i> Choose Language</a>
                <a class="item"><i class="settings icon"></i> Account Settings</a>
            </div>
        </div>
        <div class="right item">
            <div class="ui input"><input type="text" placeholder="Search..."></div>
        </div>
    </div>
</div>




