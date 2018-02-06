<script src="/js/validation.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Факультеты:
    <c:forEach var="faculty" items="${listFaculties}">
        <form name="changeFaculty" action="controller" method="post">
            <div class="ui form">
                <div class="fields">
                    <div class="field">
            <input type="hidden" name="command" value="deleteFaculty">
           ID <input type="text" name="facultyId" value="${faculty.getId()}"/>
           Название <input type="text" name="facultyName"  value="${faculty.getName()}"/>
           Дата начала приёма документов <input type="text" name="startDateOfFiling"  value="${faculty.getStartDateOfFiling()}"/>
           Дата окончания приёма документов <input type="text" name="endDateOfFiling" value="${faculty.getEndDateOfFiling()}"/>
                   </div>
                </div>
            </div>
            <div class="ui input">
        <input class="ui active button" value="Delete" type="submit">

        <div class="ui active button">
            <c:url value="controller?command=changeFaculty" var="change">
                <c:param name="facultyId" value="${faculty.getId()}"/>
            </c:url>
            <a href=${change}>Change</a></div></div>
        </form>
    </c:forEach>
<div class="ui active button" ><a href="controller?command=createFaculty">Create new faculty</a></div>