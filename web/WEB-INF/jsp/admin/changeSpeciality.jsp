<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Специальности:
<c:set var="speciality" value="${speciality}"/>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="changeSpeciality"/>
         <input type="text" name="specialityId"  value="${speciality.getId()}"/>
        <input type="text" name="specialityName"  value="${speciality.getName()}"/>
         <input type="text" name="facultyId" value="${speciality.getFacultyId()}"/>
        <input type="text" name="numberBudgetPlace" value="${speciality.getNumberBudgetPlace()}"/>
        <input type="text" name="numberPaidPlace" value="${speciality.getNumberPaidPlace()}"/>

        <input class="ui active button" value="Delete" type="submit">
        <input type="submit" class="ui active button" value="Change"/>
    </form>

