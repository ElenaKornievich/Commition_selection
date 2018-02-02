<form name="createFaculty" action="controller" method="post">
    <input type="hidden" name="command" value="createFaculty"/>

    <input type="text" name="nameFaculty" value="">
    <input type="text" name="startDate" value="">
    <input type="text" name="endDate" value="">

    <select name="subjectOneId">
        <c:forEach var="subject" items="${subjects}" >
            <option value="${subject.getId()}">${subject.getName()}</option>
        </c:forEach>
    </select>

        <select name="subjectTwoId">
            <c:forEach var="subject" items="${subjects}" >
                <option value="${subject.getId()}">${subject.getName()}</option>
            </c:forEach>
        </select>

        <select name="subjectThreeId">
            <c:forEach var="subject" items="${subjects}" >
                <option value="${subject.getId()}">${subject.getName()}</option>
            </c:forEach>
        </select>
<br/>
    <input class="ui button" type="submit" value="Cancel" name="cancel" formaction="controller" formmethod="get"/>
    <div class="or"></div>
    <input type="submit" class="ui positive button" name="change" value="Change"/>

</form>