
<form name="createAdmin" action="controller" method="post">
    <input type="hidden" name="command" value="createAdmin">

    Пользователь: <input type="text" name="login"  size="10" ><br>
    Пароль: <input type="password" name="password" size="10"><br>

    <input type="text" name="surname" value="">
    <input type="text" name="firstName" value="">
    <input type="text" name="lastName" value="">

    <input class="ui button" type="submit" value="Cancel" name="cancel" formaction="controller" formmethod="get" />
    <div class="or"></div>
    <input type="submit" class="ui positive button" name="change" value="Change"/>

</form>