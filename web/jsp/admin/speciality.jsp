<script src="/js/validation.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="form-position">
    <fmt:message key="speciality.label.specialities"/>
<c:forEach var="speciality" items="${listSpeciality}">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="deleteSpeciality">
        <input type="hidden" name="specialityId" value="${speciality.getId()}"/>
        <input type="hidden" name="facultyId" value="${speciality.getFacultyId()}"/>
        <input type="hidden" name="specialityName" value="${speciality.getName()}"/>
        <input type="hidden" name="numberOfBudgetPlace" value="${speciality.getNumberBudgetPlace()}"/>
        <input type="hidden" name="numberOfPaidPlace" value="${speciality.getNumberPaidPlace()}"/>
            ${speciality.getId()} ${speciality.getName()} ${speciality.getFacultyId()} ${speciality.getNumberBudgetPlace()}
                    ${speciality.getNumberPaidPlace()}
                <input class="ui active button" value="<fmt:message key="common.button.delete"/>" type="submit"/>

        <div class="ui active button">
            <c:url value="controller?command=changeSpeciality" var="change">
                <c:param name="specialityId" value="${speciality.getId()}"/>
            </c:url><a href=${change}><fmt:message key="common.button.change"/></a></div>
    </form>
</c:forEach>
<div class="ui active button" ><a href="controller?command=createSpeciality"><fmt:message key="speciality.button.create"/></a></div>
</div>