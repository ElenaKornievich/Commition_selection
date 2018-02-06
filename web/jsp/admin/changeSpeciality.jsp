<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Специальности:
<c:set var="speciality" value="${speciality}"/>
<script src="/js/validation.js"></script>
    <form name="changeSpeciality" action="controller" method="post" onsubmit="return validateChangeSpeciality()">
        <input type="hidden" name="command" value="changeSpeciality"/>
         <input type="text" pattern="[0-9]+" name="specialityId"  value="${speciality.getId()}"/>
        <input type="text" name="specialityName"  value="${speciality.getName()}"/>
         <input type="hidden" name="facultyId" value="${speciality.getFacultyId()}"/>
        <input type="text" pattern="[0-9]+" name="numberBudgetPlace" value="${speciality.getNumberBudgetPlace()}"/>
        <input type="text" pattern="[0-9]+" name="numberPaidPlace" value="${speciality.getNumberPaidPlace()}"/>

        <input class="ui active button" value="Delete" type="submit">
        <input type="submit" class="ui active button" value="Change"/>
    </form>

