<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
>
<html xmlns="http://www.w3.org/1999/xhtml">
<script src="/js/validation.js"></script>

<link rel="stylesheet" href="/css/style.css">
<%@include file="header.jsp" %>
<h1><fmt:message key="queue.text.listSpecialities"/></h1>

    <c:forEach var="speciality" items="${specialities}">
        <div class="form-position">
        <form name="queue" action="controller" method="post">
            <div class="ui form">
                <div class="fields">
                    <div class="field">
                        <label><fmt:message key="speciality.label.specialityName"/></label>
                        <input type="hidden" name="command" value="queue">
                        <div><input type="hidden" name="specialityId" value="${speciality.getId()}">
                            <c:out value="${speciality.getName()}"/>
                        </div>
                    </div>
                    <div class="ui field" style="margin-left: 17.6%">

                        <div class="ui buttons">
                            <input class="ui button" type="submit" value="<fmt:message key="queue.button.viewQueue"/>"/>
                        </div>


                    </div>
                </div>
            </div>

        </form>   </div>
    </c:forEach>

</body>
</html>
