
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml">
<script src="/js/validation.js"></script>

<%@include file="header.jsp"%>
<link rel="stylesheet" href="/css/authorization.css" type="text/css">

<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<!-- Site Properties -->
<title>Login Example - Semantic</title>

<link rel="stylesheet" type="text/css" href="/SemanticUI/components/divider.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/segment.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/form.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/input.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/button.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/message.css">
<link rel="stylesheet" type="text/css" href="../css/authorization.css">


<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/SemanticUI/components/form.js"></script>
<script src="/SemanticUI/components/transition.js"></script>
<script src="../js/authorization.js"></script>
<style type="text/css">

</style>
<script>

</script>

<title>Login</title>
<div class="wrapper">
     <div class="ui middle aligned center aligned grid">
         <div class="column">
             <h2 class="ui teal image header">

                 <div class="content">
                     <fmt:message key="login.text.loginToYourAccount"/>
                 </div>
             </h2>
             <form class="ui large form">
                 <div class="ui stacked segment">
                     <div class="field">
                         <div class="ui left icon input">
                             <i class="user icon"></i>
    <input type="hidden" name="command" value="login" />
    <input type="text"  placeholder="Login" name="login" minlength="4" maxlength="42" value=""/>
                         </div>
                     </div>
                     <div class="field">
                         <div class="ui left icon input">
                             <i class="lock icon"></i>
    <input type="password" name="password"  placeholder="<fmt:message key="login.label.password"/>" minlength="4" maxlength="42" value=""/>
                         </div>
                     </div>
                     <input class="ui fluid large teal submit button" formmethod="post" formaction="controller" type="submit" value="<fmt:message key="login.label.login"/>"/>
                 </div>

                 <div class="ui error message"></div>

             </form>

             <div class="ui message">
                 <a href="controller?command=registration"><fmt:message key="login.button.signUp"/></a>
             </div>
         </div>
     </div>


</div>

</body></html>