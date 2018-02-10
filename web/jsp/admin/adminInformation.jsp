
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="form-position">
<form name="adminInformation" >
    <c:set value="${admin}" var="admin"/>
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label> <fmt:message key="common.label.surname"/></label>
                <div class="ui input">
                    <c:out value="${admin.getSurname()}"/>
                </div>
            </div>
            <div class="field">
                <label> <fmt:message key="common.label.firstName"/></label>
                <div class="ui input">
                    <c:out value="${admin.getFirstName()}"/>
                </div>
            </div>
            <div class="field">
                <label> <fmt:message key="common.label.lastName"/></label>
                <div class="ui input">
                    <c:out value="${admin.getSecondName()}"/>
                </div>
            </div>
        </div>
    </div>
</form>
</div>