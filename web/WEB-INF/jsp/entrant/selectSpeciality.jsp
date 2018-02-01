<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link type="text/css" rel="stylesheet" href="/css/personalArea.css">
<script src="/js/jquery-3.2.1.min.js"></script>
<%@include file="../header.jsp" %>


<form name="test" action="controller" method="post" >
    <input type="hidden" name="command" value="changeSpeciality">

    <select name="specialityId">
        <c:forEach var="speciality" items="${specialities}">
            <option value="${speciality.getId()}"> ${speciality.getName()}</option>
        </c:forEach>
    </select>

    <input type="submit" name="command" value="changeSpeciality"/>
</form>
</body>
</html>
