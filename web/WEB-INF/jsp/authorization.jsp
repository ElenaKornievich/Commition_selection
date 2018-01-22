
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@include file="header.jsp"%>
<link rel="stylesheet" href="/css/authorization.css" type="text/css">
<title>Login</title>
<div class="wrapper">
<form class="form" name="loginForm" >
    <input type="hidden" name="command" value="login" />
   <p>Login:</p>
    <input type="text" name="login" minlength="4" maxlength="42" value=""/>
    <p>Password:<p/>
    <input type="password" name="password" minlength="4" maxlength="42" value=""/>
    <br/>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
    <input class="submit" formmethod="post" formaction="controller" type="submit" value="Log in"/>
    <input class="submit" formmethod="get" value="Registration" type="submit" formaction="registration"/>
</form><hr/>
</div>

</body></html>