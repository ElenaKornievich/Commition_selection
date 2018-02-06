<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Внесите необходимые изменение в специальность:
<c:set var="subject" scope = "page" value="${subject}"/>
<script src="/js/validation.js"></script>
<form name="changeSubject" action="controller" method="post" onsubmit="return validateChangeSubject()">
    <input type="hidden" name="command" value="changeSubject">
    <input type="hidden" name="subjectId" value="${subject.getId()}">
    <input type="text" name="subjectName"  value="${subject.getName()}"/>

    <input class="ui active button" value="Delete" type="submit"/>
    <input class="ui active button" name="changeSubject" type="submit" value="Change"/>
</form>

