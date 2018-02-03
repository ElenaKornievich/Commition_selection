
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Факультеты:
    <c:forEach var="faculty" items="${listFaculties}">
        <div>
       ${faculty.getId()} ${faculty.getName()} ${faculty.getStartDateOfFiling()} ${faculty.getEndDateOfFiling()}
        </div>
    </c:forEach>
