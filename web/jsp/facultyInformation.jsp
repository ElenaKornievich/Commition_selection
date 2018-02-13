<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<%@include file="header.jsp" %>
<div class="form-position">
<h2><fmt:message key="faculty.text.faculty"/> ${faculty.getName()}</h2>
<h3><fmt:message key="faculty.label.subjects"/>:</h3>
<c:forEach var="subject" items="${facultySubjectName}">
    <form name="deleteSubject" action="controller" method="post">
         ${subject}
    </form>
</c:forEach>
<h3><fmt:message key="faculty.text.facultySpecialities"/></h3>
<c:forEach var="speciality" items="${listSubjects}">
    <form name="deleteSubject" action="controller" method="post">
            ${speciality.getName()}
    </form>
</c:forEach>
</div>
</body>
</html>
