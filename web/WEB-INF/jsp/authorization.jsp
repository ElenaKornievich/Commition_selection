
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml">


<%@include file="header.jsp"%>
<link rel="stylesheet" href="/css/authorization.css" type="text/css">

<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<!-- Site Properties -->
<title>Login Example - Semantic</title>
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/reset.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/site.css">

<link rel="stylesheet" type="text/css" href="/SemanticUI/components/container.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/grid.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/header.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/image.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/menu.css">

<link rel="stylesheet" type="text/css" href="/SemanticUI/components/divider.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/segment.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/form.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/input.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/button.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/list.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/message.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/components/icon.css">

<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/SemanticUI/components/form.js"></script>
<script src="/SemanticUI/components/transition.js"></script>

<style type="text/css">
    body {
        background-color: #DADADA;
    }
    body > .grid {
        height: 100%;
    }
    .image {
        margin-top: -100px;
    }
    .column {
        max-width: 450px;
    }
</style>
<script>
    $(document)
        .ready(function() {
            $('.ui.form')
                .form({
                    fields: {
                        email: {
                            identifier  : 'email',
                            rules: [
                                {
                                    type   : 'empty',
                                    prompt : 'Please enter your e-mail'
                                },
                                {
                                    type   : 'email',
                                    prompt : 'Please enter a valid e-mail'
                                }
                            ]
                        },
                        password: {
                            identifier  : 'password',
                            rules: [
                                {
                                    type   : 'empty',
                                    prompt : 'Please enter your password'
                                },
                                {
                                    type   : 'length[6]',
                                    prompt : 'Your password must be at least 6 characters'
                                }
                            ]
                        }
                    }
                })
            ;
        })
    ;
</script>

<title>Login</title>
<div class="wrapper">
     <div class="ui middle aligned center aligned grid">
         <div class="column">
             <h2 class="ui teal image header">

                 <div class="content">
                     Log-in to your account
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
    <input type="password" name="password"  placeholder="Password" minlength="4" maxlength="42" value=""/>
                         </div>
                     </div>
                     <input class="ui fluid large teal submit button" formmethod="post" formaction="controller" type="submit" value="Login"/>
                 </div>

                 <div class="ui error message"></div>

             </form>

             <div class="ui message">
                 New to us? <a href="controller?command=registration">Sign Up</a>
             </div>
         </div>
     </div>


</div>

</body></html>