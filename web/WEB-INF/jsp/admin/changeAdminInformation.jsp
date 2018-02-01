
<? xml version="1.0" encoding="UTF-8" ?>
Hello,
<table>
    <tr>
        <th>Id</th>
        <th>Surname</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <tr>${admin.getId()}</tr>
    <tr>
        ${admin.getSurname()}
    </tr>
    <tr>
        ${admin.getFirstName()}
    </tr>
    <tr>
        ${admin.getSecondName()}
    </tr>
</table>
<form method="get" action="controller">
<input type="hidden" name="idAdmin" value="${admin.getId()}">
<input type="text" name="surname" value="${admin.getSurname()}">
<input type="text" name="firstName" value="${admin.getFirstName()}">
<input type="text" name="lastName" value="${admin.getSecondName()}">

    <input type="hidden" name="command" value="changeAdmin"/>
    <div class="ui buttons">

        <input class="ui button" type="submit" value="Cancel" name="cancel" formaction="controller" formmethod="get" />
<div class="or"></div>
        <input type="submit" class="ui positive button" name="change" formmethod="post" formaction="controller"
               value="Change"/>

        <c:set var="execute" value="${execute}"/>
        <c:if test="${execute>0}">
            Выполнено!!!!
        </c:if>
    </div>
</form>