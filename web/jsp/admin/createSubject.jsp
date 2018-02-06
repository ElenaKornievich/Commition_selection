<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h3>Создать предмет</h3>
<script src="/js/validation.js"></script>
<form name="createSubject" action="controller" method="post" onsubmit="return validateCreateSubject()">
    <input type="hidden" name="command" value="createSubject"/>
    <div class="ui input">
    <input type="text" name="subjectName" value="" placeholder="Имя"/>

    </div>
<br/>
    <div class="ui buttons">
        <c:url value="controller?command=adminPanel" var="change">
            <c:param name="changeEntrantParam" value="${entrant.getId()}"/>
        </c:url>
        <div  class="ui button"> <a href=${change}>Up</a></div>
        <div class="or"></div>
        <input type="submit" class="ui positive button" name="change" value="Change"/>
    </div>
    <!--
<div>
    <input class="ui button" type="submit" value="Cancel" name="cancel" formaction="controller" formmethod="get"/>
    <div class="or"></div>
    <input type="submit" class="ui positive button" name="change" value="Change"/>
    </div>-->
</form>