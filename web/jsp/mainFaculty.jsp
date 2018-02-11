<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="/js/validation.js"></script>

<%@include file="header.jsp"%>

<h1><fmt:message key="faculty.text.listFaculties"/></h1>
<div class="ui form">
    <div class="three fields">
        <div class="field">
            <label><fmt:message key="faculty.label.nameFaculty"/></label>

        </div>
        <div class="field">
            <label><fmt:message key="faculty.label.startDate"/></label>

        </div>
        <div class="field">
            <label><fmt:message key="faculty.label.endDate"/></label>

        </div>
    </div>
</div>
    <c:forEach var = "faculty" items="${listFaculty}">
        <form>
            <input type="hidden" name="command" value="facultyInformation">
            <input type="hidden" name="facultyId" value="${faculty.getId()}">
        <div class="ui form">
        <div class="three fields">
        <div class="field">

       <c:out value = "${faculty.getName()}"/>
        </div>
        <div class="field">

        <c:out value = "${faculty.getStartDateOfFiling()}"/>
        </div>
        <div class="field">

        <c:out value = "${faculty.getEndDateOfFiling()}"/>
        </div>
        </div>
        </div>
            <div class="ui active button">
                <c:url value="controller?command=facultyInformation" var="more">
                    <c:param name="facultyId" value="${faculty.getId()}"/>
                </c:url>
                <a href=${more}><fmt:message key="common.text.more"/></a>
            </div>
        </form>
    </c:forEach>

</body>
</html>
