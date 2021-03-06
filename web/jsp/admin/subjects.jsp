<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/js/validation.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="form-position">
    <fmt:message key="subject.label.subjects"/>
<c:forEach var="subject" items="${listSubject}">
    <form name="deleteSubject" action="controller" method="post">
        <input type="hidden" name="command" value="deleteSubject">
        <input type="hidden" name="subjectId" value="${subject.getId()}"/> ${subject.getId()}
        <input type="hidden" name="subjectName" value="${subject.getName()}"/> ${subject.getName()}


    <div class="ui input">
        <input class="ui active button" value="<fmt:message key="common.button.delete"/>" type="submit"/>
        <div class="ui active button">
            <c:url value="controller?command=changeSubject" var="change">
                <c:param name="subjectId" value="${subject.getId()}"/>
            </c:url>
            <a href=${change}><fmt:message key="common.button.change"/></a></div>
    </div>
    </form>
</c:forEach>

<div class="ui active button" ><a href="controller?command=createSubject"><fmt:message key="subject.button.create"/></a></div>
</div>