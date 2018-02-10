<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="form-position">
Внесите необходимые изменение в предмет:
<c:set var="subject" scope="page" value="${subject}"/>
<script src="/js/validation.js"></script>
<form name="changeSubject" action="controller" method="post" onsubmit="return validateChangeSubject()">


    <input type="hidden" name="command" value="changeSubject">
    <input type="hidden" name="subjectId" value="${subject.getId()}">
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label>Название</label>
                <div class="ui input">
                    <input type="text" name="subjectName" value="${subject.getName()}"/>
                </div>
            </div>
        </div>
    </div>

    <div class="ui field">
        <div class="field">
            <div class="ui buttons">
                <div class="ui button"><a href="controller?command=adminPanel">Cancel</a></div>
                <div class="or"></div>
                <input class="ui positive button" name="changeSubject" type="submit" value="Change"/>
            </div>
        </div>
    </div>

</form>

</div>