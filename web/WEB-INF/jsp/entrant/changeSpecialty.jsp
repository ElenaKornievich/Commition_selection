<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<form name="test" action="controller" method="post" >
    <input type="hidden" name="command" value="changeSpeciality">

    <select name="specialityId">
        <c:forEach var="speciality" items="${specialities}">
            <option value="${speciality.getId()}"> ${speciality.getName()}</option>
        </c:forEach>
    </select>

    <input type="submit" name="command" value="changeSpeciality"/>
</form>
