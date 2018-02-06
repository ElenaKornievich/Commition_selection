<%--
  Created by IntelliJ IDEA.
  User: Fox
  Date: 30.01.2018
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>queue</title>
</head>
<body>
<h1>Здесь должна быть очередь!!!!</h1>
<li><a href=#>Menu 4</a>
    <ul class="submenu">
        <li><a href=#>Sudmenu 4</a></li>
        <li><a href=#>Sudmenu 4</a></li>
        <li><a href=#>Sudmenu 4</a></li>
    </ul>
</li>
<script src="/js/validation.js"></script>
<form action="select1.php" method="post">
    <p><select name="hero[]">
        <option selected>Выберите героя</option>
        <option name="mmf" href="controller?command=mmf" value="MMF">MMF</option>
        <option name="fpm" value="FPM">FPM</option>
        <option value="Шапокляк">Шапокляк</option>
        <option value="Крыса Лариса">Крыса Лариса</option>
    </select></p>
    <p><input type="submit" value="Отправить"></p>
</form>

<table>
    <c:forEach var = "i" items="${entrant}">
        : <c:out value = "${i}"/>
    </c:forEach>
</table>
</body>
</html>
