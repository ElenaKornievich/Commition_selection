<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Предметы:
<c:forEach var="subject" items="${listSubject}">
    <form>
    <div>

            ${subject.getId()} ${subject.getName()}
    </div>
    <input class="ui active button" value="Delete" type="submit">
        <c:url value="controller?command=changeSubject" var="change">
            <c:param name="subjectId" value="${subject.getId()}"/>
        </c:url>

        <div class="ui active button"><a href=${change}>Change</a></div>
    </form>
</c:forEach>
