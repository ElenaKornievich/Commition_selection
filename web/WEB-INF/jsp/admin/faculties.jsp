
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Факультеты:
    <c:forEach var="faculty" items="${listFaculties}">
        <div>
            <input type="hidden" name="facultyId" value="${faculty.getId()}">
            <input type="text" name="facultyName"  value="${speciality.getName()}"/>
            <input type="text" name="startDateOfFiling"  value="${faculty.getStartDateOfFiling()}"/>
            <input type="text" name="endDateOfFiling" value="${faculty.getEndDateOfFiling()}"/>
        ${faculty.getId()} ${faculty.getName()} ${faculty.getStartDateOfFiling()} ${faculty.getEndDateOfFiling()}
        </div>
        <input class="ui active button" value="Delete" type="submit">
        <div class="ui active button"><a href="controller?command=changeFaculty">Change</a></div>

    </c:forEach>
