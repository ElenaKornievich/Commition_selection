
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml">


<%@include file="header.jsp"%>
<link rel="stylesheet" href="/css/authorization.css" type="text/css">
<title>Login</title>
<div class="wrapper">
    <table>
        <c:forEach var = "i" items="${users}">
            Item <c:out value = "${i.login}"/>
        </c:forEach>
    </table>

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
    <input class="submit" formmethod="get" value="registration" type="submit" formaction="controller"/>
</form><hr/>

</div>

</body></html>