
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml">
<script src="/js/validation.js"></script>

<%@include file="header.jsp"%>
<h1>Здесь должна быть очередь!!!!</h1>


<table>

    <c:forEach var = "speciality" items="${specialities}">
        <form name="queue" action="controller" method="post">
            <input name="command" value="queue">
        <div><input type="hidden" name="specialityId" value="${speciality.getId()}">
            <c:out value = "${speciality.getName()}"/>
            <input type="submit" value="Посмотреть очередь на факультет">
        </div>
        </form>
    </c:forEach>
</table>
</body>
</html>
