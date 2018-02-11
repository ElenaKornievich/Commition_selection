<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="form-position">
<h3> <fmt:message key="admin.text.createAdmin"/></h3>

<script src="/js/validation.js"></script>
<form name="createAdmin" action="controller" method="post" onsubmit="return validateCrateAdmin()">
    <input type="hidden" name="command" value="createAdmin">
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label><fmt:message key="login.label.login"/></label>
                <div class="ui input">
                    <input type="text" value="" placeholder="<fmt:message key="login.label.login"/>" name="login" size="10">
                </div>
            </div>
            <div class="field">
                <label><fmt:message key="login.label.password"/></label>
                <div class="ui input">
                    <input type="password" value="" placeholder="<fmt:message key="login.label.password"/>" name="password" size="10">
                </div>
            </div>
        </div>
    </div>


    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label><fmt:message key="common.label.surname"/></label>
                <input type="text" name="surname" value=""/>
            </div>
            <div class="field">
                <label><fmt:message key="common.label.firstName"/></label>
                <input type="text" name="firstName" value=""/>
            </div>
            <div class="field">
                <label><fmt:message key="common.label.lastName"/></label>
                <input type="text" name="lastName" value="" />
            </div>
        </div>
    </div>

    <div class="ui field" style="margin-left: 17.6%">
        <div class="ui buttons">
            <c:url value="controller?command=adminPanel" var="change">
                <c:param name="changeEntrantParam" value="${entrant.getId()}"/>
            </c:url>
            <div class="ui button"><a href="controller?command=adminPanel"><fmt:message key="common.button.cancel"/></a></div>
            <div class="or"></div>
            <input type="submit" class="ui positive button" name="change" value="<fmt:message key="common.button.save"/>"/>
        </div>
    </div>
</form>
</div>