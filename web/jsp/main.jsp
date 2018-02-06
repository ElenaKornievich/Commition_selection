<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="/css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/bootstrap/css/bootstrap-theme.css" type="text/css" media="screen">
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.css" type="text/css" media="screen">

    <script src="/bootstrap/js/bootstrap.js"></script>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/validation.js"></script>
</head>
<body>

<fmt:message key="login.label.login"/>
<div class="container">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="img/MMF.jpg" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"  ></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div id="myCarousel" class="carousel slide">
            <div class="carousel-inner">
                <div class="item active">
                    <img src="img/MMF.jpg" alt="0">
                    <div class="carousel-caption">
                        ...
                    </div>
                    ...
                </div>

                <div class="item">
                    <img src="img/FMO.jpg" alt="">
                    <div class="carousel-caption">
                        ...
                    </div>
                    ...
                </div>

                <div class="item">
                    <img src="img/1.jpg" alt="">
                    <div class="carousel-caption">
                        ...
                    </div>
                    ...
                </div>
            </div>
        </div>
        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>

</div><!-- /.container -->



</body>
</html>