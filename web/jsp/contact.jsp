<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<%@include file="header.jsp" %>
<div class="form-position">
<h1><fmt:message key="common.text.listAdmin"/></h1>
<table>

        <c:forEach var="admin" items="${listAdmin}"><tr>
            <td><c:out value="${admin.getSurname()}"/></td>
            <td><c:out value="${admin.getFirstName()}"/></td>
            <td><c:out value="${admin.getSecondName()}"/></td>
        </tr>  </c:forEach>

</table>
</div>
</body>
</html>
