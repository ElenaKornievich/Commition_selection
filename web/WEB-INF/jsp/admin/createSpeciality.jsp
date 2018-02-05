<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="createSpeciality" action="controller" method="post">
    <input type="hidden" name="command" value="createSpeciality"/>
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label>Имя специальности</label>
                <input type="text" name="nameSpeciality" placeholder="nameSpeciality">
            </div>
            <div class="field">
                <label>Количество бюджетных мест</label>
                <input type="text" name="numberOfBudgetPlaces" placeholder="numberOfBudgetPlaces">
            </div>
            <div class="field">
                <label>Количество платных мест</label>
                <input type="text" name="numberOfPainPlaces" placeholder="numberOfPainPlaces">
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
                <div class="ui button"><a href=${change}>Cancel</a></div>
                <div class="or"></div>
                <input class="ui positive button" type="submit" value="Craete" name="cancel"/>
            </div>
        </div>
    </div>
    </div>
</form>
