<form name="createFaculty" action="controller" method="post">
    <input type="hidden" name="command" value="createSubject"/>
    <div class="ui input">
    <input type="text" name="nameSubject" value="nameSubject" placeholder="Имя"/>

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