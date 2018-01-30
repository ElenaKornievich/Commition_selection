<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Login</title></head>
<body>
<link rel="stylesheet" href="/css/style.css" type="text/css" media="screen">
<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login" />
    Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    <div  class="${login}"> <br/>Бла бла бал</div>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>

    <input type="submit" value="Log in"/>
</form><hr/>
<div  class="${login}"> <br/>Бла бла бал</div>
</body></html>
