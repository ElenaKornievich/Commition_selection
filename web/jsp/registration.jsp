<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<link type="text/css" rel="stylesheet" href="/css/registration.css">
<script src="/js/validation.js"></script>
<h1>Регистрация посетителей</h1>

<div class="ui horizontal divider">or</div>
<div class="registrationForm">
    <form class="ui form segment" name="registration" onsubmit="return validateRegistrationForm()">
        <input type="hidden" name="command" value="registration">
        <p>Регистрация</p>

        <div class="two fields">
            <div class="field">
                <label>Username</label>
                <input type="text" placeholder="Логин" name="login">
            </div>
            <div class="field">
                <label>Password</label>
                <input type="password" placeholder="Пароль" minlength="6" name="password">
            </div>
        </div>
        <div class="three fields">
            <div class="field">
                <label>Surname</label>
                <input type="text" placeholder="Фамилия" name="surname">
            </div>
            <div class="field">
                <label>Имя</label>
                <input type="text" placeholder="Имя" name="firstName">
            </div>
            <div class="field">
                <label>Отчество</label>
                <input type="text" placeholder="Отчество" name="lastName">
            </div>
        </div>
        <div class="three fields">
            <div class="field">
                <label>Серия паспорта</label>
                <input type="text" placeholder="Серия паспорта" name="pasportSeria">
            </div>
            <div class="field">
                <label>Номер паспорта</label>
                <input type="text" placeholder="Номер паспорта" name="pasportNomer" pattern="[0-9]{7}">
            </div>
            <div class="field">
                <label>Дата выдачи паспорта</label>
                <input type="text" placeholder="YYYY-MM-DD" name="dataOfIssue" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
            </div>
        </div>
        <div class="three fields">
            <div class="field">
                <label>Идентификационый номер</label>
                <input type="text" placeholder="Идентификационый номер" name="identificationNumber">
            </div>
            <div class="field">
                <label>Дата рождения</label>
                <input type="text" placeholder="YYYY-MM-DD" name="dataOfBirth" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
            </div>
            <div class="field">
                <label>Национальность</label>
                <input type="text" placeholder="Национальность" name="nationality">
            </div>
        </div>
        <div class="three fields">
            <div class="field">
                <label>Адрес прописки</label>
                <input type="text" placeholder="Адрес прописки" name="residenceAddress">
            </div>
            <div class="field">
                <label>Балл аттестата</label>
                <input type="text" name="score" minlength="1" placeholder="9.50" pattern="\d+(\.\d{2})?">
            </div>
            <div class="field">
                <label>Золотая медаль</label>
                <input type="text" placeholder=" есть: 1, нет: 0" name="goldMedal" size="10" pattern="[01]{1}">
            </div>
        </div>

        <div class="two fields">
            <div class="field">
                <label>Адрес электронной почты</label>
                <input type="text" name="email">
            </div>
            <div class="field">
                <label>Номер телефона</label>
                <input type="text" name="telephoneNumber">
            </div>
        </div>

        <div class="field">
            <label>Skills</label>
            <div>
                <select name="subjectOneId">
                    <c:forEach var="subject" items="${subjects}">
                        <option value="${subject.getId()}">${subject.getName()}</option>
                    </c:forEach>
                </select>
                <input type="text" name="subjectOneValue" value="">
            </div>
            <div>
                <select name="subjectTwoId">
                    <c:forEach var="subject" items="${subjects}">
                        <option value="${subject.getId()}">${subject.getName()}</option>
                    </c:forEach>
                </select>
                <input type="text" name="subjectTwoValue" value="">
            </div>
            <div>
                <select name="subjectThreeId">
                    <c:forEach var="subject" items="${subjects}">
                        <option value="${subject.getId()}">${subject.getName()}</option>
                    </c:forEach>
                </select>
                <input type="text" name="subjectThreeValue" value="">
            </div>
        </div>
        <div class="ui field" style="margin-left: 17.6%">
            <div class="ui buttons">
                <div class="ui button"><a href="controller?command=main">Отмена</a></div>
                <div class="or"></div>
                <input type="submit" class="ui positive button" name="save" value="Сохранить" formaction="controller"
                       formmethod="post">
            </div>
        </div>

    </form>
</div>

</body>
</html>
