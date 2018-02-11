<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="form-position">
<h3><fmt:message key="speciality.text.createSpeciality"/></h3>
<script src="/js/validation.js"></script>
<form name="createSpeciality" action="controller" method="post" onsubmit="return validateCreateSpeciality()">


    <input type="hidden" name="command" value="createSpeciality"/>
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label><fmt:message key="speciality.label.specialityName"/></label>
                <input type="text" name="specialityName" value="" />
            </div>
            <div class="field">
                <label><fmt:message key="speciality.label.numberBudgetPlace"/>т</label>
                <input type="text" pattern="[0-9]+" name="numberBudgetPlace" value=""/>
            </div>
            <div class="field">
                <label><fmt:message key="speciality.label.numberPaidPlace"/></label>
                <input type="text" pattern="[0-9]+" name="numberPaidPlace" value=""/>
            </div>
        </div>
        <div class="two fields">
            <div class="field">
                <select class="ui fluid dropdown" name="facultyId">
                    <c:forEach var="faculty" items="${faculties}">
                        <option value="${faculty.getId()}">${faculty.getName()}</option>
                    </c:forEach>
                </select>
            </div>

        </div>
        <div class="fields">
            <div class="ui field">
                <div class="ui buttons">
                    <c:url value="controller?command=adminPanel" var="change">
                        <c:param name="changeEntrantParam" value="${entrant.getId()}"/>
                    </c:url>
                    <div class="ui button"><a href="controller?command=adminPanel"><fmt:message key="common.button.cancel"/></a></div>
                    <div class="or"></div>
                    <input class="ui positive button" type="submit" value="<fmt:message key="common.button.save"/>" name="create"/>
                </div>
            </div>
        </div>
    </div>
</form>
</div>