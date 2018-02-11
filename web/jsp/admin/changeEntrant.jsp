<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<link rel="stylesheet" type="text/css" href="/SemanticUI/semantic.min.css">
<script
        src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous"></script>
<script src="/SemanticUI/semantic.min.js"></script>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/SemanticUI/accordion/UI-Accordion-master/accordion.min.js"></script>
<script src="/SemanticUI/accordion/UI-Accordion-master/accordion.js"></script>
<link rel="stylesheet" type="text/css" href="/SemanticUI/accordion/UI-Accordion-master/accordion.css">
<link rel="stylesheet" type="text/css" href="/SemanticUI/accordion/UI-Accordion-master/accordion.min.css">

<div class="form-position">
<div class="ui styled accordion">

    <c:forEach items="${entrants}" var="entrant">

        <div class="title active">
            <i class="dropdown icon"></i>
                ${entrant.getSurname()} ${entrant.getFirstName()} ${ entrant.getLastName()}

            <div class="ui buttons">
                <div class="ui active button">
                    <c:url value="controller?command=deleteEntrant" var="delete">
                        <c:param name="idEntrant" value="${entrant.getId()}"/>
                    </c:url>
                    <a href=${delete}><fmt:message key="common.button.delete"/></a></div>

            </div>
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
                    <td><fmt:message key="speciality.label.specialityId"/></td>
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
                    <td><fmt:message key="common.label.surname"/></td>
                    <td>${entrant.getSurname()}</td>
                </tr>
                <tr>
                    <td><fmt:message key="common.label.firstName"/></td>
                    <td>${entrant.getFirstName()}</td>
                </tr>
                <tr>
                    <td><fmt:message key="common.label.lastName"/></td>
                    <td>${ entrant.getLastName()}</td>
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


    </c:forEach>
</div>
</div>