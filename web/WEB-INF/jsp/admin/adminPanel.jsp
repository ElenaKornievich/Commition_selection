
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<link type="text/css" rel="stylesheet" href="/css/adminPanel.css">

    <%@include file="../header.jsp"%>


<div class="nav">
<div class="ui vertical menu">
        <a class="teal item active" href="controller?command=changeAdmin">
    changeAdmin

    </a>
    <a class="item" href="controller?command=aboutMe">
        aboutMe

    </a>
    <a class="item" href="controller?command=changeButton">
        changeButton

    </a>
    </a>
    <a class="item" href="controller?command=speciality">
        Speciality

    </a>
   <!-- <a class="item" href="controller?command=deleteFaculty">
        DeleteFaculty

    </a> -->
    <a class="item" href="controller?command=subject" >
        Subject

    </a>
  <!--  <a class="item" href="controller?command=createFaculty">
        createFaculty

    </a>-->
    <a class="item" href="controller?command=faculty">
        Faculty

    </a>
   <!-- <a class="item" href="controller?command=createSubject">
        createSubject

    </a>
    <a class="item" href="controller?command=createSpeciality">
        createSpeciality

    </a>-->
    <a class="item" href="controller?command=createAdmin">
        createAdmin
    </a>
   <!-- <div class="item">
        <div class="ui transparent icon input">
            <input type="text" placeholder="Search mail...">
            <i class="search icon"></i>
        </div>
    </div>-->
</div>
</div>

<!-- <div class="nav">
        <form name="changeButton" action="controller" method="get">
            <input type="hidden" name="command" value="changeButton" />
            <br/><input name="navParameter" value="changeEntrant" type="submit" >
        </form>

        <form name="changeAdmin" action="controller" method="get">
            <input type="hidden" name="command" value="changeAdmin" />

            <br/><input value="changeAdmin" type="submit"  >
        </form>

        <form name="about" action="controller" method="get">
            <input type="hidden" name="command" value="about" />
            <br/><input value="aboutMe" type="submit" name="navParameter">
        </form>

        <form name="createFaculty" action="controller" method="get">
            <input type="hidden" name="command" value="createFaculty" />
            <br/><input value="createFaculty" type="submit" name="navParameter">
        </form>

        <form name="createSubject" action="controller" method="get">
            <input type="hidden" name="command" value="createSubject" />
            <br/><input value="createSubject" type="submit" name="navParameter">
        </form>

        <form name="createSpeciality" action="controller" method="get">
            <input type="hidden" name="command" value="createSpeciality" />
            <br/><input value="createSpeciality" type="submit" name="navParameter">
        </form>

        <form name="createAdmin" action="controller" method="get">
            <input type="hidden" name="command" value="createAdmin" />
            <br/><input value="createAdmin" type="submit" name="navParameter">
        </form>
    </div>
    <div> -->
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
                list 3
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
                <%@include file="speciality.jsp"%>
            </c:when>
            <c:when test="${nav == 14}">
                <%@include file="subject.jsp"%>
            </c:when>
            <c:otherwise>
                Не выбрано ни одно условие.
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>
