<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="form-position">
<h3><fmt:message key="subject.text.createSubject"/></h3>
<script src="/js/validation.js"></script>
<form name="createSubject" action="controller" method="post" onsubmit="return validateCreateSubject()">
    <input type="hidden" name="command" value="createSubject"/>
    <div class="ui input">
    <input type="text" name="subjectName" value="" placeholder="<fmt:message key="speciality.label.specialityName"/>"/>

    </div>
<br/>
    <div class="ui buttons">
        <c:url value="controller?command=adminPanel" var="change">
            <c:param name="changeEntrantParam" value="${entrant.getId()}"/>
        </c:url>
        <div  class="ui button"> <a href="controller?command=adminPanel" ><fmt:message key="common.button.cancel"/></a></div>
        <div class="or"></div>
        <input type="submit" class="ui positive button" name="change" value="<fmt:message key="common.button.save"/>"/>
    </div>
</form>
</div>