<form name="createFaculty" action="controller" method="post">
    <input type="hidden" name="command" value="createFaculty"/>
    Пользователь: <input type="text" name="login" size="10"><br>
    Пароль: <input type="password" name="password" size="10"><br>

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

    <input class="ui button" type="submit" value="Cancel" name="cancel" formaction="controller" formmethod="get"/>
    <div class="or"></div>
    <input type="submit" class="ui positive button" name="change" value="Change"/>

</form>