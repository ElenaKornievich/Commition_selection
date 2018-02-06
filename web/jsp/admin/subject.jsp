<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/js/validation.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

Предметы:
<c:forEach var="subject" items="${listSubject}">
    <form name="DELETESUBJECT" action="controller" method="post">
        <input type="hidden" name="command" value="DELETESUBJECT">
        <input type="hidden" name="subjectId" value="${subject.getId()}"/> ${subject.getId()}
        <input type="hidden" name="subjectName" value="${subject.getName()}"/> ${subject.getName()}
        <input class="ui active button" value="Delete" type="submit"/>
    </form>
        <div class="ui active button">
            <c:url value="controller?command=changeSubject" var="change">
                <c:param name="subjectId" value="${subject.getId()}"/>
            </c:url>
            <a href=${change}>Change</a></div>

</c:forEach>

<div class="ui active button" ><a href="controller?command=createSubject">Create new subject</a></div>
