<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="/js/validation.js"></script>

<%@include file="header.jsp"%>

<h1>Тут много текста о всех факультетах</h1>
<table>
    <c:forEach var = "faculty" items="${listFaculty}"><tr>
       <td> <c:out value = "${faculty.getName()}"/></td>
        <td><c:out value = "${faculty.getStartDateOfFiling()}"/></td>
        <td> <c:out value = "${faculty.getEndDateOfFiling()}"/></td></tr>
    </c:forEach>
</table>
</body>
</html>
