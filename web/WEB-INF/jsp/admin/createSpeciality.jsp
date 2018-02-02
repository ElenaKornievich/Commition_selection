<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="createSpeciality" action="controller" method="post">
    <input type="hidden" name="command" value="createSpeciality"/>

    <input type="text" name="nameSpeciality" value="">
    <input type="text" name="numberOfBudgetPlaces" value="">
    <input type="text" name="numberOfPainPlaces" value="">

    <select name="facultyId">
        <c:forEach var="faculty" items="${faculties}" >
            <option value="${faculty.getId()}">${faculty.getName()}</option>
        </c:forEach>
    </select>


    <br/>
    <input class="ui button" type="submit" value="Cancel" name="cancel" formaction="controller" formmethod="get"/>
    <div class="or"></div>
    <input type="submit" class="ui positive button" name="change" value="Change"/>

</form>
