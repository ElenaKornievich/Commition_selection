
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml">
<script src="/js/validation.js"></script>

<%@include file="header.jsp"%>

<div class="form-position">
<c:set value="${speciality}" var="speciality"/>
Количество бюджетных мест
${speciality.getNumberBudgetPlace()}
количество платных мест
${speciality.getNumberPaidPlace()}

    <div class="ui form">
        <div class="four fields">
            <div class="field">
                <label><fmt:message key="turn.label.sumPoints"/></label>

            </div>
            <div class="field">
                <label><fmt:message key="common.label.surname"/></label>

            </div>
            <div class="field">
                <label><fmt:message key="common.label.firstName"/></label>

            </div>
            <div class="field">
                <label><fmt:message key="common.label.lastName"/></label>

            </div>
        </div>

    <c:forEach var = "queue" items="${queue}">
        <form name="queue" action="controller" method="post">
            <div><input type="hidden" name="specialityId" value="">
                <div class="four fields">
                        <div class="field">
                ${queue.getSumOfScores()}
                        </div>
                        <div class="field">
                ${queue.getSurname()}
                        </div>
                        <div class="field">
                ${queue.getFirstName()}
                        </div>
                        <div class="field">
                ${queue.getLastName()}
                        </div>
                    </div>
                </div>

        </form>
        <a href="controller?command=queue"></a>
    </c:forEach>
    </div>
</div>
</body>
</html>

