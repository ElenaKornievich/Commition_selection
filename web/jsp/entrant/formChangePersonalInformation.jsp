<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="/js/validation.js"></script>
<form name="changePersonalInformation" action="controller" method="post" onsubmit="return validatechangePersonalInformation()">
    <input type="hidden" name="command" value="change">
    <label>surname: </label><input type="text" value="${surname}" name="surname" size="15"><br>
    <label>firstName:</label> <input type="text" value="${firstName}" name="firstName" size="15"><br>
    <label>lastName: </label><input type="text" value="${lastName}" name="lastName" size="15"><br>
    <label>pasportSeria:</label> <input type="text" value="${pasportSeria}" name="pasportSeria" size="10"><br>
    <label>pasportNomer: </label><input type="text" value="${pasportNomer}" name="pasportNomer" size="10"><br>
    <label>DataOfIssue: </label><input type="text" placeholder="YYYY-MM-DD" value="${dateOfIssue}" name="dataOfIssue" size="10"><br>
    <label>IdentificationNumber:</label> <input type="text" value="${identificationNumber}" name="identificationNumber"
                                                size="20"><br>
    <label>DataOfBirth:</label> <input placeholder="YYYY-MM-DD" type="text" value="${dataOfBirth}" name="dataOfBirth" size="10"><br>
    <label>Nationality:</label> <input type="text" value="${nationality}" name="nationality" size="20"><br>
    <label>ResidenceAddress:</label> <input type="text" value="${residenceAddress}" name="residenceAddress"
                                            size="50"><br>
    <label>Scope:</label> <input type="text" value="${scope}" name="scope" size="10"><br>
    <label>GoldMedal:</label> <input type="text" value="${goldMedal}" name="goldMedal" size="10"><br>
    <label>Email:</label> <input type="text" value="${email}" name="email" size="10"><br>
    <label>TelephoneNumber:</label> <input type="text" value="${telephoneNumber}" name="telephoneNumber" size="10"><br>
    <label>specialityName: </label><input type="text" value="${specialityName}" name="specialityName" size="10"><br>

    <select name="specialityId">
        <c:forEach var="specialityId" items="${specialities}">
            <option value="${speciality.getId()}"> ${speciality.getName()}</option>
        </c:forEach>
    </select>
    <p>
    <table>
        <tr>
            <th>
                <small>
                    <input type="submit" name="save" value="Сохранить" formaction="controller" formmethod="post">
                </small>
            <th>
                <small>
                    <input type="button" name="cancel" value="Выйти">
                </small>
    </table>
</form>

