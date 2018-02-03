<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="createSpeciality" action="controller" method="post">
    <input type="hidden" name="command" value="createSpeciality"/>
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label>Имя специальности</label>
                <input type="text" name="nameSpeciality" placeholder="nameSpeciality">
            </div>
            <div class="field">
                <label>Количество бюджетных мест</label>
                <input type="text" name="numberOfBudgetPlaces" placeholder="numberOfBudgetPlaces">
            </div>
            <div class="field">
                <label>Количество платных мест</label>
                <input type="text" name="numberOfPainPlaces" placeholder="numberOfPainPlaces">
            </div>
        </div>

        <select name="facultyId">
            <c:forEach var="faculty" items="${faculties}">
                <option value="${faculty.getId()}">${faculty.getName()}</option>
            </c:forEach>
        </select>
        <br/>
        <div class="ui buttons">
            <c:url value="controller?command=adminPanel" var="change">
                <c:param name="changeEntrantParam" value="${entrant.getId()}"/>
            </c:url>
            <div class="ui button"><a href=${change}>Cancel</a></div>
            <div class="or"></div>
            <input class="ui button" type="submit" value="Cancel" name="cancel" formaction="controller"
                   formmethod="get"/>
        </div>
        <!--  <div>
          <input class="ui button" type="submit" value="Cancel" name="cancel" formaction="controller" formmethod="get"/>
          <div class="or"></div>
          <input type="submit" class="ui positive button" name="change" value="Change"/>
          </div> -->
</form>
