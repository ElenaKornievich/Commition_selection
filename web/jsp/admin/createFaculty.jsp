

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h3> Создать факультет</h3>
<script src="/js/validation.js"></script>
<form name="createFaculty" action="controller" method="post" onsubmit="return validateCreateFaculty()">
    <input type="hidden" name="command" value="createFaculty"/>

    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label>Имя факультета</label>
                <div class="ui input">
                    <input type="text" name="nameFaculty" value="" placeholder="Имя">
                </div>
            </div>
            <div class="field">
                <label>Дата начала приёма</label>
                <div class="ui input">
                    <input type="text" name="startDate" value="" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" placeholder="YYYY-MM-DD">
                </div>
            </div>
            <div class="field">
                <label>Дата окончания приёма</label>
                <div class="ui input">
                    <input type="text" name="endDate" value="" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" placeholder="YYYY-MM-DD">
                </div>
            </div>
        </div>
    </div>

    <!--  <div class="ui input">
      <input type="text" name="nameFaculty" value="nameFaculty" placeholder="Имя">
      </div>
      <div class="ui input">
      <input type="text" name="startDate" value="startDate" placeholder="Дата начала приёма">
      </div>
      <div class="ui input">
      <input type="text" name="endDate" value="endDate" placeholder="Дата окончания приёма">
      </div>-->
    <div class="field">
        <label>Предметы, необходимые при подаче документов</label>

            <select name="subjectOneId" class="ui dropdown">
                <c:forEach var="subject" items="${subjects}">
                    <option value="${subject.getId()}">${subject.getName()}</option>
                </c:forEach>
            </select>

            <select name="subjectTwoId" class="ui dropdown">
                <c:forEach var="subject" items="${subjects}">
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
                    <c:url value="controller?command=adminPanel" var="change">
                        <c:param name="changeEntrantParam" value="${entrant.getId()}"/>
                    </c:url>
                    <div class="ui button"><a href="controller?command=adminPanel">Отмена</a></div>
                    <div class="or"></div>
                    <input type="submit" class="ui positive button" name="change" value="Сохранить"/>
                </div>
            </div>
        </div>
    </div>
        <!-- <div>
         <input class="ui button" type="submit" value="Cancel" name="cancel" formaction="controller" formmethod="get"/>
         <div class="or"></div>
         <input type="submit" class="ui positive button" name="change" value="Change"/>
         </div> -->
</form>