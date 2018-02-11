<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="form-position">
<h2>Привет ${user}</h2>
<div class="title active">
    ${entrant.getSurname()} ${entrant.getFirstName()} ${ entrant.getLastName()}

</div>

<div class="content active">
    <p class="transition visible" style="display: block !important;">
    <table>
        <tr>
            <td><fmt:message key="common.label.id"/></td>
            <td>${entrant.getId()}</td>
        </tr>
        <tr>
            <td><fmt:message key="entrant.label.dateOfFilling"/></td>
            <td>${entrant.getDateOfFilling()}</td>
        </tr>
        <tr>
            <td>Id специальности</td>
            <td>${entrant.getSpecialityId()}</td>
        </tr>
        <tr>
            <td><fmt:message key="entrant.label.pasportSeria"/></td>
            <td>${entrant.getPasportSeries()}</td>
        </tr>
        <tr>
            <td><fmt:message key="entrant.label.pasportNomer"/></td>
            <td>${entrant.getPassportNumber()}</td>
        </tr>
        <tr>
            <td><fmt:message key="entrant.label.dataOfIssue"/></td>
            <td>${entrant.getDateOfIssue()}</td>
        </tr>
        <tr>
            <td><fmt:message key="entrant.label.identificationNumber"/></td>
            <td>${entrant.getIdentificationNumber()}</td>
        </tr>
        <tr>
            <td><fmt:message key="entrant.label.dateOfBirth"/></td>
            <td>${entrant.getDateOfBirth()}</td>
        </tr>
        <tr>
            <td><fmt:message key="entrant.label.nationality"/></td>
            <td>${entrant.getNationality()}</td>
        </tr>
        <tr>
            <td><fmt:message key="entrant.label.telephoneNumber"/></td>
            <td>${entrant.getTelephoneNumber()}</td>
        </tr>
        <tr>
            <td><fmt:message key="entrant.label.residenceAddress"/></td>
            <td>${entrant.getResidenceAddress()}</td>
        </tr>
        <tr>
            <td><fmt:message key="entrant.label.score"/></td>
            <td>${entrant.getScore()}</td>
        </tr>
        <tr>
            <td><fmt:message key="entrant.label.goldMedal"/></td>
            <td>${entrant.isGoldMedal()}</td>
        </tr>
        <tr>
            <td><fmt:message key="entrant.label.email"/></td>
            <td>${entrant.getEmail()}</td>
        </tr>

    </table>

</div>
</div>