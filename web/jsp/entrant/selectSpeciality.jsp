<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link type="text/css" rel="stylesheet" href="/css/personalArea.css">
<script src="/js/jquery-3.2.1.min.js"></script>
<div class="form-position">
<script src="/js/validation.js"></script>
<form name="test" action="controller" method="post" >
    <input type="hidden" name="command" value="changeEntrantSpeciality">

    <select name="specialityId">
        <c:forEach var="speciality" items="${specialities}">
            <option value="${speciality.getId()}"> ${speciality.getName()}</option>
        </c:forEach>
    </select>

    <input type="submit" name="command" value="<fmt:message key="common.button.change"/>"/>
</form>
</div>
