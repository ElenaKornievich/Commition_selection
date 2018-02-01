<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link type="text/css" rel="stylesheet" href="/css/personalArea.css">
<script src="/js/jquery-3.2.1.min.js"></script>
<%@include file="../header.jsp" %>


<div class="nav">
    <form name="change" action="controller" method="ge59-t">
    <input type="hidden" name="command" value="change" />
    <br/><input name="navParameter" value="changePersonalInformation" type="submit" ></form>

    <form name="changeSpeciality" action="controller" method="get">
        <input type="hidden" name="command" value="changeSpeciality" />
        <br/><input value="changeSpeciality" type="submit" name="speciality" >
    </form>

    <form name="about" action="controller" method="get">
        <input type="hidden" name="command" value="about" />
    <br/><input value="aboutMe" type="submit" name="navParameter">
    </form>
</div>
<div>

    <c:set var = "nav" scope = "page" value = "${nav}"/>
    <c:choose>
        <c:when test="${nav == 1}">
            <%@include file="aboutMe.jsp"%>
            <%@include file="formChangePersonalInformation.jsp"%>
        </c:when>
        <c:when test="${nav == 2}">
            <%@include file="changeSpesialty.jsp"%>
        </c:when>
        <c:when test="${nav == 3}">
            <%@include file="aboutMe.jsp"%>
            <c:out value="${sexNow}"/>
        </c:when>
        <c:otherwise>
            Не выбрано ни одно условие.
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
