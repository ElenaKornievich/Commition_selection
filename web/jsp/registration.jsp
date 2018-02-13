<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<link type="text/css" rel="stylesheet" href="/css/registration.css">
<script src="/js/validation.js"></script>


<div class="ui horizontal divider"><fmt:message key="registration.text.registration"/></div>
<div class="registrationForm">
    <form class="ui form segment" name="registration" onsubmit="return validateRegistrationForm()">
        <input type="hidden" name="command" value="registration">


        <div class="two fields">
            <div class="field">
                <label><fmt:message key="login.label.login"/></label>
                <input type="text"  name="login">
            </div>
            <div class="field">
                <label><fmt:message key="login.label.password"/></label>
                <input type="password"  minlength="6" name="password">
            </div>
        </div>
        <div class="three fields">
            <div class="field">
                <label><fmt:message key="common.label.surname"/></label>
                <input type="text"  name="surname">
            </div>
            <div class="field">
                <label><fmt:message key="common.label.firstName"/></label>
                <input type="text"  name="firstName">
            </div>
            <div class="field">
                <label><fmt:message key="common.label.lastName"/></label>
                <input type="text" name="lastName">
            </div>
        </div>
        <div class="three fields">
            <div class="field">
                <label><fmt:message key="entrant.label.pasportSeria"/></label>
                <input type="text" placeholder="МС" name="pasportSeria">
            </div>
            <div class="field">
                <label><fmt:message key="entrant.label.pasportNomer"/></label>
                <input type="text" placeholder="1234567" name="pasportNomer" pattern="[0-9]{7}">
            </div>
            <div class="field">
                <label><fmt:message key="entrant.label.dataOfIssue"/></label>
                <input type="text" placeholder="YYYY-MM-DD" name="dataOfIssue" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
            </div>
        </div>
        <div class="three fields">
            <div class="field">
                <label><fmt:message key="entrant.label.identificationNumber"/></label>
                <input type="text" placeholder="1234567A123BP3" name="identificationNumber">
            </div>
            <div class="field">
                <label><fmt:message key="entrant.label.dateOfBirth"/></label>
                <input type="text" placeholder="YYYY-MM-DD" name="dataOfBirth" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
            </div>
            <div class="field">
                <label><fmt:message key="entrant.label.nationality"/></label>
                <input type="text" placeholder="<fmt:message key="registration.text.nationality"/>" name="nationality">
            </div>
        </div>
        <div class="three fields">
            <div class="field">
                <label><fmt:message key="entrant.label.residenceAddress"/></label>
                <input type="text" name="residenceAddress">
            </div>
            <div class="field">
                <label><fmt:message key="entrant.label.score"/></label>
                <input type="text" name="score" minlength="1" placeholder="9.50" pattern="\d+(\.\d{2})?">
            </div>
            <div class="field">
                <label><fmt:message key="entrant.label.goldMedal"/></label>
                <input type="text" placeholder="<fmt:message key="registration.text.goldMedal"/>" name="goldMedal" size="10" pattern="[01]{1}">
            </div>
        </div>

        <div class="two fields">
            <div class="field">
                <label><fmt:message key="entrant.label.email"/></label>
                <input type="text" name="email" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}"  placeholder="ivanov@gmail.com">
            </div>
            <div class="field">
                <label><fmt:message key="entrant.label.telephoneNumber"/></label>
                <input type="text" name="telephoneNumber" placeholder="+375292727272">
            </div>
        </div>

        <div class="field">
            <label><fmt:message key="registration.label.ctPoints"/></label>
            <div>
                <select name="subjectOneId">
                    <c:forEach var="subject" items="${subjects}">
                        <option value="${subject.getId()}">${subject.getName()}</option>
                    </c:forEach>
                </select>
                <label><fmt:message key="registration.label.score"/></label>
                <input type="text" name="subjectOneValue" pattern="[0-9]{2,3}" value="">
            </div>
            <div>
                <select name="subjectTwoId">
                    <c:forEach var="subject" items="${subjects}">
                        <option value="${subject.getId()}">${subject.getName()}</option>
                    </c:forEach>
                </select>
                <label><fmt:message key="registration.label.score"/></label>
                <input type="text" name="subjectTwoValue" pattern="[0-9]{2,3}" value="">
            </div>
            <div>
                <select name="subjectThreeId">
                    <c:forEach var="subject" items="${subjects}">
                        <option value="${subject.getId()}">${subject.getName()}</option>
                    </c:forEach>
                </select>
                <label><fmt:message key="registration.label.score"/></label>
                <input type="text" name="subjectThreeValue" pattern="[0-9]{2,3}" value="">
            </div>
        </div>
        <div class="ui field" style="margin-left: 17.6%">
            <div class="ui buttons">
                <div class="ui button"><a href="controller?command=main"><fmt:message key="common.button.cancel"/></a></div>
                <div class="or"></div>
                <input type="submit" class="ui positive button" name="save" value="<fmt:message key="common.button.save"/>" formaction="controller"
                       formmethod="post">
            </div>
        </div>

    </form>
</div>

</body>
</html>
