
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

Специальности:
<c:forEach var="speciality" items="${listSpeciality}">
    <form action="controller" method="get">
        <input type="hidden" name="command" value="changeSpeciality">
        <input type="hidden" name="specialityId" value="${speciality.getId()}"
        <input type="hidden" name="facultyId" value="${speciality.getFacultyId()}">
        <input type="hidden" name="specialityName" value="${speciality.getName()}">
        <input type="hidden" name="numberOfBudgetPlace" value="${speciality.getNumberBudgetPlace()}">
        <input type="hidden" name="numberOfPaidPlace" value="${speciality.getNumberPaidPlace()}">
            ${speciality.getId()} ${speciality.getName()} ${speciality.getFacultyId()} ${speciality.getNumberBudgetPlace()}
                    ${speciality.getNumberPaidPlace()}
                <input class="ui active button" value="Delete" type="submit">
    </form>
    <form>
        <div class="ui active button"><a href="controller?command=changeSpeciality">Change</a></div>
    </form>
</c:forEach>
