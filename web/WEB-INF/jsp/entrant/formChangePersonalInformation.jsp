<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<form  name="changePersonalInformation" action="controller" method="post">
    <input type="hidden" name="command" value="change">
surname: <input type="text" name="surname" size="15"><br>
firstName: <input type="text" name="firstName" size="15"><br>
lastName: <input type="text" name="lastName" size="15"><br>
pasportSeria: <input type="text" name="pasportSeria" size="10"><br>
pasportNomer: <input type="text" name="pasportNomer" size="10"><br>
DataOfIssue: <input type="text" name="dataOfIssue" size="10"><br>
IdentificationNumber: <input type="text" name="identificationNumber" size="20"><br>
DataOfBirth: <input type="text" name="dataOfBirth" size="10"><br>
Nationality: <input type="text" name="nationality" size="20"><br>
ResidenceAddress: <input type="text" name="residenceAddress" size="50"><br>
Scope: <input type="text" name="scope" size="10"><br>
GoldMedal: <input type="text" name="goldMedal" size="10"><br>
Email: <input type="text" name="email" size="10"><br>
TelephoneNumber: <input type="text" name="telephoneNumber" size="10"><br>
specialityName: <input type="text"  name="specialityName" size="10"><br>
<select  name="spjjecialityName" >
    <option>1</option>
    <option>Veb</option>
</select>
    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="save" value="Сохранить" formaction="controller" formmethod="post">
            </small>
            <th><small>
                <input type="button" name="cancel" value="Выйти">
            </small>
    </table>
</form>

