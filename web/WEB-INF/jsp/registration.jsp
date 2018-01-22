<%--
  Created by IntelliJ IDEA.
  User: Fox
  Date: 22.12.2017
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Форма регистрации посетителей</title>
</head>
<body>
<h1>Регистрация посетителей</h1>

<form  name="registrationPage">
    <input type="hidden" name="command" value="registration">
    Пользователь: <input type="text" name="login"  size="10" ><br>
    Пароль: <input type="password" name="password" size="10"><br>
    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="save" value="Сохранить" formaction="controller" formmethod="post">
            </small>
            <th><small>
                <input type="button" name="cancel" value="Выйти">
            </small>
    </table>
</form>
</body>
</html>
