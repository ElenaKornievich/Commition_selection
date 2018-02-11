<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="form-position">
    <fmt:message key="speciality.label.specialities"/>
<c:set var="speciality" value="${speciality}"/>
<script src="/js/validation.js"></script>
<form name="changeSpeciality" action="controller" method="post" onsubmit="return validateChangeSpeciality()">
    <input type="hidden" name="command" value="changeSpeciality"/>
    <div class="ui form">
        <div class="fields">

            <input type="hidden" name="specialityId" value="${speciality.getId()}"/>
            <div class="field">
                <label><fmt:message key="speciality.label.specialityName"/></label>
                <div class="ui input">
                    <input type="text" name="specialityName" value="${speciality.getName()}"/>
                </div>
            </div>

                    <input type="hidden" name="facultyId" value="${speciality.getFacultyId()}"/>

            <div class="field">
                <label><fmt:message key="speciality.label.numberBudgetPlace"/></label>
                <div class="ui input">
                    <input type="text" pattern="[0-9]+" name="numberBudgetPlace"
                           value="${speciality.getNumberBudgetPlace()}"/>
                </div>
            </div>
            <div class="field">
                <label><fmt:message key="speciality.label.numberPaidPlace"/></label>
                <div class="ui input"><input type="text" pattern="[0-9]+" name="numberPaidPlace"
                                             value="${speciality.getNumberPaidPlace()}"/>
                </div>
            </div>
        </div>
    </div>
    <div class="ui field">
        <div class="field">
            <div class="ui buttons">
                <div class="ui button"><a href="controller?command=adminPanel"><fmt:message key="common.button.cancel"/></a></div>
                <div class="or"></div>
                <input type="submit" class="ui positive button" value="<fmt:message key="common.button.change"/>"/>
            </div>
        </div>
    </div>


</form>

</div>