<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="/js/validation.js"></script>
<div class="form-position">
<form name="changeEntrantSpeciality" action="controller" method="post" >
    <input type="hidden" name="command" value="changeEntrantSpeciality">
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label>Специальность</label>
                ${speciality}
                <select name="specialityId">
                    <c:forEach var="speciality" items="${specialities}">
                        <option value="${speciality.getId()}"> ${speciality.getName()}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>

    <input class="ui active button" type="submit" name="command" value="changeEntrantSpeciality"/>
</form>
</div>