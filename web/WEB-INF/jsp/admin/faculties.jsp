
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Факультеты:
    <c:forEach var="faculty" items="${listFaculties}">
        <form name="changeFaculty" action="controller" method="post">
        <div>
            <input type="hidden" name="command" value="deleteFaculty">
            <input type="text" name="facultyId" value="${faculty.getId()}"/>
            <input type="text" name="facultyName"  value="${faculty.getName()}"/>
            <input type="text" name="startDateOfFiling"  value="${faculty.getStartDateOfFiling()}"/>
            <input type="text" name="endDateOfFiling" value="${faculty.getEndDateOfFiling()}"/>
        ${faculty.getId()} ${faculty.getName()} ${faculty.getStartDateOfFiling()} ${faculty.getEndDateOfFiling()}

        <input class="ui active button" value="Delete" type="submit">
            </div>
        <div class="ui active button">
            <c:url value="controller?command=changeFaculty" var="change">
                <c:param name="facultyId" value="${faculty.getId()}"/>
            </c:url>
            <a href=${change}>Change</a></div>
        </form>
    </c:forEach>
<div class="ui active button" ><a href="controller?command=createFaculty">Create new faculty</a></div>