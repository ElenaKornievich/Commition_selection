<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Предметы:
<c:forEach var="subject" items="${listSubject}">
    <form>
    <div>
        <input type="hidden" name="subjectId" value="${subject.getId()}">
        <input type="hidden" name="subjectName" value="${subject.getName()}">
            ${subject.getId()} ${subject.getName()}
    </div>
    <input class="ui active button" value="Delete" type="submit">

        <div class="ui active button"><a href="controller?command=changeSpeciality">Change</a></div>
    </form>
</c:forEach>
