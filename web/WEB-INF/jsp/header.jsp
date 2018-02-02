<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

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
        <a href="controller?command=personalArea" class="item">
            <i class="mail icon"></i> Личный кабинет
        </a>
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



