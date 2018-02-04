<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Специальности:
<c:set var="subject" scope = "page" value="${subject}"/>
<form >
    <input type="hidden" name="command" value="changeSpeciality">
    <input type="hidden" name="specialityId" value="${subject.getId()}">
    <input type="text" name="specialityId"  value="${subject.getId()}"/>

    <input class="ui active button" value="Delete" type="submit">
    <div class="ui active button"><a href="controller?command=changeSubject">Change</a></div>
</form>

