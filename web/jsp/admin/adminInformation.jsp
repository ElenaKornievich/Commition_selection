
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="form-position">
<form name="adminInformation" >
    <c:set value="${admin}" var="admin"/>
    <div class="ui form">
        <div class="fields">
            <div class="field">
                <label>Фамилия</label>
                <div class="ui input">
                    <c:out value="${admin.getSurname()}"/>
                </div>
            </div>
            <div class="field">
                <label>Имя</label>
                <div class="ui input">
                    <c:out value="${admin.getFirstName()}"/>
                </div>
            </div>
            <div class="field">
                <label>Отчество</label>
                <div class="ui input">
                    <c:out value="${admin.getSecondName()}"/>
                </div>
            </div>
        </div>
    </div>
</form>
</div>