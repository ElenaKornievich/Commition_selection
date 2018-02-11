<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<script src="/js/validation.js"></script>
<div class="form-position">
    <fmt:message key="faculty.label.faculties"/>
    <c:forEach var="faculty" items="${listFaculties}">
        <form name="changeFaculty" action="controller" method="post">
            <div class="ui form">
                <div class="fields">
                    <div class="field">
                        <input type="hidden" name="command" value="deleteFaculty"/>
                        <fmt:message key="faculty.label.idFaculty"/> <input type="text" name="facultyId" value="${faculty.getId()}"/>
                        <fmt:message key="faculty.label.nameFaculty"/> <input type="text" name="facultyName" value="${faculty.getName()}"/>
                        <fmt:message key="faculty.label.startDate"/> <input type="text" name="startDateOfFiling"
                                                             value="${faculty.getStartDateOfFiling()}"/>
                        <fmt:message key="faculty.label.endDate"/> <input type="text" name="endDateOfFiling"
                                                                value="${faculty.getEndDateOfFiling()}"/>
                    </div>
                </div>
            </div>
            <div class="ui input">
                <input class="ui active button" value="Delete" type="submit"/>

                <div class="ui active button">
                    <c:url value="controller?command=changeFaculty" var="change">
                        <c:param name="facultyId" value="${faculty.getId()}"/>
                    </c:url>
                    <a href=${change}><fmt:message key="common.button.change"/></a>
                </div>
            </div>
        </form>
    </c:forEach>
    <div class="ui active button"><a href="controller?command=createFaculty"><fmt:message key="faculty.button.create"/></a></div>
</div>