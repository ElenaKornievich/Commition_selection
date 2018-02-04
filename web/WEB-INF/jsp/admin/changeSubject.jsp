<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Специальности:
<c:set var="subject" scope = "page" value="${subject}"/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="changeSubject">
    <input type="hidden" name="subjectId" value="${subject.getId()}">
    <input type="text" name="subjectName"  value="${subject.getName()}"/>

    <input class="ui active button" value="Delete" type="submit"/>
    <input class="ui active button" name="changeSubject" type="submit" value="Change"/>
</form>

