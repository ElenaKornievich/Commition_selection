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
                    <a href=${delete}>Удалить</a></div>

            </div>
        </div>

        <div class="content active">
            <p class="transition visible" style="display: block !important;">
            <table>
                <tr>
                    <td>Id</td>
                    <td>${entrant.getId()}</td>
                </tr>
                <tr>
                    <td>Дата подачи</td>
                    <td>${entrant.getDateOfFilling()}</td>
                </tr>
                <tr>
                    <td>Id специальности</td>
                    <td>${entrant.getSpecialityId()}</td>
                </tr>
                <tr>
                    <td>Серия паспорта</td>
                    <td>${entrant.getPasportSeries()}</td>
                </tr>
                <tr>
                    <td>Номер паспорта</td>
                    <td>${entrant.getPassportNumber()}</td>
                </tr>
                <tr>
                    <td>Фамилия</td>
                    <td>${entrant.getSurname()}</td>
                </tr>
                <tr>
                    <td>Имя</td>
                    <td>${entrant.getFirstName()}</td>
                </tr>
                <tr>
                    <td>Отчество</td>
                    <td>${ entrant.getLastName()}</td>
                </tr>
                <tr>
                    <td>Дата выдачи паспорта</td>
                    <td>${entrant.getDateOfIssue()}</td>
                </tr>
                <tr>
                    <td>Идентификационный номер</td>
                    <td>${entrant.getIdentificationNumber()}</td>
                </tr>
                <tr>
                    <td>Дата рождения</td>
                    <td>${entrant.getDateOfBirth()}</td>
                </tr>
                <tr>
                    <td>Национальность</td>
                    <td>${entrant.getNationality()}</td>
                </tr>
                <tr>
                    <td>Телефон</td>
                    <td>${entrant.getTelephoneNumber()}</td>
                </tr>
                <tr>
                    <td>Адрес прописки</td>
                    <td>${entrant.getResidenceAddress()}</td>
                </tr>
                <tr>
                    <td>Балл аттестата</td>
                    <td>${entrant.getScore()}</td>
                </tr>
                <tr>
                    <td>Есть/нет золотая медаль</td>
                    <td>${entrant.isGoldMedal()}</td>
                </tr>
                <tr>
                    <td>Почта</td>
                    <td>${entrant.getEmail()}</td>
                </tr>

            </table>

        </div>


    </c:forEach>
</div>