<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="form-position">
<form name="changeAdminInform" method="post" action="controller" onsubmit="return validateAdminInformation()">
    <c:set value="${admin}" var="admin"/>
    <input type="hidden" name="idAdmin" value="${admin.getId()}">
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label> <fmt:message key="common.label.surname"/></label>
                <div class="ui input">
                    <input type="text" name="surname" value="${admin.getSurname()}">
                </div>
            </div>
            <div class="field">
                <label> <fmt:message key="common.label.firstName"/></label>
                <div class="ui input">
                    <input type="text" name="firstName" value="${admin.getFirstName()}">
                </div>
            </div>
            <div class="field">
                <label> <fmt:message key="common.label.lastName"/></label>
                <div class="ui input">
                    <input type="text" name="lastName" value="${admin.getSecondName()}">
                </div>
            </div>
        </div>
    </div>
            <input type="hidden" name="command" value="changeAdmin"/>

            <div class="ui field" style="margin-left: 17.6%">

                <div class="ui buttons">

                    <div class="ui button">
                        <a href="controller?command=adminPanel"> <fmt:message key="common.button.cancel"/></a>
                    </div>
                    <div class="or"></div>
                    <input type="submit" class="ui positive button" name="change" value=" <fmt:message key="common.button.change"/>"/>

                </div>
            </div>

</form>
</div>