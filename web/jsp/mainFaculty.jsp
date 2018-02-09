<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="/js/validation.js"></script>

<%@include file="header.jsp"%>

<h1>Список всех факультетов</h1>
<div class="ui form">
    <div class="three fields">
        <div class="field">
            <label>Название</label>

        </div>
        <div class="field">
            <label>Дата начала приёма документов</label>

        </div>
        <div class="field">
            <label>Дата окончания приёма документов</label>

        </div>
    </div>
</div>
    <c:forEach var = "faculty" items="${listFaculty}">
        <div class="ui form">
        <div class="three fields">
        <div class="field">

       <c:out value = "${faculty.getName()}"/>
        </div>
        <div class="field">

        <c:out value = "${faculty.getStartDateOfFiling()}"/>
        </div>
        <div class="field">

        <c:out value = "${faculty.getEndDateOfFiling()}"/>
        </div>
        </div>
        </div>
    </c:forEach>

</body>
</html>
