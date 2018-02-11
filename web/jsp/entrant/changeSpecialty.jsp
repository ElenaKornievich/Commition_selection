<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">

<script src="/js/validation.js"></script>
<div class="form-position">
<form name="changeEntrantSpeciality" action="controller" method="post" >
    <input type="hidden" name="command" value="changeEntrantSpeciality">
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label><fmt:message key="speciality.label.speciality"/></label>
                ${speciality}
                <select name="specialityId">
                    <c:forEach var="speciality" items="${specialities}">
                        <option value="${speciality.getId()}"> ${speciality.getName()}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <input class="ui active button" type="submit" name="command" value="<fmt:message key="speciality.button.changeEntrantSpeciality"/>"/>
</form>
</div>
