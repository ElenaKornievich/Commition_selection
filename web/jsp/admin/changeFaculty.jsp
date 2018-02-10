

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="form-position">
<h3> Изменить факультет</h3>
<script src="/js/validation.js"></script>
<form name="changeFaculty" action="controller" method="post" onsubmit="return validateChangeFaculty()">
    <input type="hidden" name="command" value="changeFaculty"/>
<c:set var="faculty" value="${faculty}" scope="page"/>
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label>Имя факультета</label>
                <div class="ui input">
                    <input type="hidden" name="facultyId" value="${faculty.getId()}"/>
                    <input type="text" name="nameFaculty" value="${faculty.getName()}"/>
                </div>
            </div>
            <div class="field">
                <label>Дата начала приёма</label>
                <div class="ui input">
                    <input type="text" name="startDate" value="${faculty.getStartDateOfFiling()}" placeholder="YYYY-MM-DD"/>
                </div>
            </div>
            <div class="field">
                <label>Дата окончания приёма</label>
                <div class="ui input">
                    <input type="text" name="endDate" value="${faculty.getEndDateOfFiling()}" placeholder="YYYY-MM-DD"/>
                </div>
            </div>
        </div>
    </div>

    <div class="field">
        <label>Предметы, необходимые при подаче документов</label>

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

                    <div class="ui button"><a href="controller?command=adminPanel">Отмена</a></div>
                    <div class="or"></div>
                    <input type="submit" class="ui positive button" name="change" value="Сохранить"/>
                </div>
            </div>
        </div>
    </div>
</form>
</div>