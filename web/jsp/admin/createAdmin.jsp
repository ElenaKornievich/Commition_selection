<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="form-position">
<h3> Создать администратора</h3>

<script src="/js/validation.js"></script>
<form name="createAdmin" action="controller" method="post" onsubmit="return validateCrateAdmin()">
    <input type="hidden" name="command" value="createAdmin">
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label>Login</label>
                <div class="ui input">
                    <input type="text" value="" placeholder="login" name="login" size="10">
                </div>
            </div>
            <div class="field">
                <label>Password</label>
                <div class="ui input">
                    <input type="password" value="" placeholder="password" name="password" size="10">
                </div>
            </div>
        </div>
    </div>


    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label>Surname</label>
                <input type="text" name="surname" value="" placeholder="Фамилия">
            </div>
            <div class="field">
                <label>First Name</label>
                <input type="text" name="firstName" value="" placeholder="Имя">
            </div>
            <div class="field">
                <label>Last name</label>
                <input type="text" name="lastName" value="" placeholder="Отчество">
            </div>
        </div>
    </div>


    <!--  <div class="ui input">
              <label>Surname</label>
      <div class="ui input">
      <input type="text" name="surname" value="" placeholder="Фамилия">
      </div>
      </div>
      <div class="ui input">
          <label>First Name</label>
          <div class="ui input">
      <input type="text" name="firstName" value="" placeholder="Имя">
          </div>
      </div>
      <div class="ui input">
          <label>Last Name</label>
          <div class="ui input">
      <input type="text" name="lastName" value="" placeholder="Отчество">
          </div>
      </div>
      <br/>-->
    <div class="ui field" style="margin-left: 17.6%">
        <div class="ui buttons">
            <c:url value="controller?command=adminPanel" var="change">
                <c:param name="changeEntrantParam" value="${entrant.getId()}"/>
            </c:url>
            <div class="ui button"><a href="controller?command=adminPanel">Отмена</a></div>
            <div class="or"></div>
            <input type="submit" class="ui positive button" name="change" value="Сохранить"/>
        </div>
    </div>
    <!--  <div>
       <input class="ui button" type="submit" value="Cancel" name="cancel" formaction="controller" formmethod="get"/>
       <div class="or"></div>
       <input type="submit" class="ui positive button" name="change" value="Change"/>
   </div> -->
</form>
</div>