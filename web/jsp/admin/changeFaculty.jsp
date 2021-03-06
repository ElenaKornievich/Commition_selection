

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="form-position">
<h3><fmt:message key="faculty.label.changeFaculty"/></h3>
<script src="/js/validation.js"></script>
<form name="changeFaculty" action="controller" method="post" onsubmit="return validateChangeFaculty()">
    <input type="hidden" name="command" value="changeFaculty"/>
<c:set var="faculty" value="${faculty}" scope="page"/>
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label><fmt:message key="faculty.label.nameFaculty"/></label>
                <div class="ui input">
                    <input type="hidden" name="facultyId" value="${faculty.getId()}"/>
                    <input type="text" name="nameFaculty" value="${faculty.getName()}"/>
                </div>
            </div>
            <div class="field">
                <label><fmt:message key="faculty.label.startDate"/></label>
                <div class="ui input">
                    <input type="text" name="startDate" value="${faculty.getStartDateOfFiling()}" placeholder="YYYY-MM-DD"/>
                </div>
            </div>
            <div class="field">
                <label><fmt:message key="faculty.label.endDate"/></label>
                <div class="ui input">
                    <input type="text" name="endDate" value="${faculty.getEndDateOfFiling()}" placeholder="YYYY-MM-DD"/>
                </div>
            </div>
        </div>
    </div>

    <div class="field">
        <label><fmt:message key="faculty.label.subjects"/></label>

        <select name="subjectOneId"  class="ui dropdown">
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.getId()}">${subject.getName()}</option>
            </c:forEach>
        </select>

        <select name="subjectTwoId"  class="ui dropdown">
            <c:forEach var="subject"  items="${subjects}">
                <option value="${subject.getId()}">${subject.getName()}</option>
            </c:forEach>
        </select>

        <select name="subjectThreeId" class="ui dropdown">
            <c:forEach var="subject" items="${subjects}">
                <option value="${subject.getId()}">${subject.getName()}</option>
            </c:forEach>
        </select>

        <div class="ui field">
            <div class="field">
                <div class="ui buttons">

                    <div class="ui button"><a href="controller?command=adminPanel"><fmt:message key="common.button.cancel"/></a></div>
                    <div class="or"></div>
                    <input type="submit" class="ui positive button" name="change" value="<fmt:message key="common.button.change"/>"/>
                </div>
            </div>
        </div>
    </div>
</form>
</div>