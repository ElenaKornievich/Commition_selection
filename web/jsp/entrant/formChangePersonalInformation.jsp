<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="form-position">
<h3><fmt:message key="entrant.label.changePersonalInformation"/></h3>
<script src="/js/validation.js"></script>
<form name="changePersonalInformation" action="controller" method="post" onsubmit="return validateChangePersonalInformation()">
    <input type="hidden" name="command" value="change">
    <c:set var="entrant" value="${entrant}"/>
    <label><fmt:message key="common.label.surname"/>: </label><input type="text" value="${entrant.getSurname()}" name="surname" size="15"/><br>
    <label><fmt:message key="common.label.firstName"/>:</label> <input type="text" value="${entrant.getFirstName()}" name="firstName" size="15"/><br>
    <label><fmt:message key="common.label.lastName"/>: </label><input type="text" value="${entrant.getLastName()}" name="lastName" size="15"/><br>
    <label><fmt:message key="entrant.label.pasportSeria"/>:</label> <input type="text" value="${entrant.getPasportSeries()}" name="pasportSeria" size="10"/><br>
    <label><fmt:message key="entrant.label.pasportNomer"/>: </label><input type="text" pattern="[0-9]{7}" value="${entrant.getPassportNumber()}" name="pasportNomer" size="10"/><br>
    <label><fmt:message key="entrant.label.dataOfIssue"/>: </label><input type="text" placeholder="YYYY-MM-DD" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value="${entrant.getDateOfIssue()}" name="dataOfIssue" size="10"/><br>
    <label><fmt:message key="entrant.label.identificationNumber"/>:</label> <input type="text" value="${entrant.getIdentificationNumber()}" name="identificationNumber"
                                                size="20"/><br>
    <label><fmt:message key="entrant.label.dateOfBirth"/>:</label> <input placeholder="YYYY-MM-DD" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" type="text" value="${entrant.getDateOfBirth()}" name="dataOfBirth" size="10"/><br>
    <label><fmt:message key="entrant.label.nationality"/>:</label> <input type="text" value="${entrant.getNationality()}" name="nationality" size="20"/><br>
    <label><fmt:message key="entrant.label.residenceAddress"/>:</label> <input type="text" value="${entrant.getResidenceAddress()}" name="residenceAddress"
                                            size="50"/><br>
    <label><fmt:message key="entrant.label.score"/>:</label> <input type="text" value="${entrant.getScore()}" name="scope" size="10"/><br>
    <label><fmt:message key="entrant.label.goldMedal"/>:</label> <input type="text" value="${entrant.isGoldMedal()}" name="goldMedal" size="10"/><br>
    <label><fmt:message key="entrant.label.email"/>:</label> <input type="text" value="${entrant.getEmail()}" name="email" size="10"/><br>
    <label><fmt:message key="entrant.label.telephoneNumber"/>:</label> <input type="text" value="${entrant.getTelephoneNumber()}" name="telephoneNumber" size="10"/><br>
    <input type="hidden" value="${entrant.getSpecialityId()}" name="specialityId" size="10"/><br>

    <p>

    <div class="ui field" style="margin-left: 17.6%">
        <div class="ui buttons">
            <div class="ui button" >
                <a href="controller?command=main"><fmt:message key="common.button.cancel"/></a>
            </div>
            <div class="or"></div>
            <input type="submit" class="ui positive button" name="save" value="<fmt:message key="common.button.save"/>"/>
        </div>
    </div>

</form>
</div>
