
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>



    <%@include file="../header.jsp"%>

    <div class="nav">
        <form name="changeButton" action="controller" method="get">
            <input type="hidden" name="command" value="changeButton" />
            <br/><input name="navParameter" value="changeEntrant" type="submit" >
        </form>

        <form name="changeAdmin" action="controller" method="get">
            <input type="hidden" name="command" value="changeAdmin" />

            <br/><input value="changeAdmin" type="submit"  >
        </form>

        <form name="about" action="controller" method="get">
            <input type="hidden" name="command" value="about" />
            <br/><input value="aboutMe" type="submit" name="navParameter">
        </form>

        <form name="createFaculty" action="controller" method="get">
            <input type="hidden" name="command" value="createFaculty" />
            <br/><input value="createFaculty" type="submit" name="navParameter">
        </form>

        <form name="createSubject" action="controller" method="get">
            <input type="hidden" name="command" value="createSubject" />
            <br/><input value="createSubject" type="submit" name="navParameter">
        </form>

        <form name="createSpeciality" action="controller" method="get">
            <input type="hidden" name="command" value="createSpeciality" />
            <br/><input value="createSpeciality" type="submit" name="navParameter">
        </form>

        <form name="createAdmin" action="controller" method="get">
            <input type="hidden" name="command" value="createAdmin" />
            <br/><input value="createAdmin" type="submit" name="navParameter">
        </form>
    </div>
    <div>

        <c:set var = "nav" scope = "page" value = "${nav}"/>
        <c:choose>
            <c:when test="${nav == 1}">
                <%@include file="changeEntrant.jsp"%>
            </c:when>
            <c:when test="${nav == 2}">
                <%@include file="changeAdminInformation.jsp"%>
            </c:when>
            <c:when test="${nav == 3}">
                list 3
            </c:when>
            <c:when test="${nav == 4}">
                <%@include file="pointCTEntrant.jsp"%>
            </c:when>
            <c:when test="${nav == 5}">
                <%@include file="createAdmin.jsp"%>
            </c:when>
            <c:when test="${nav == 6}">
                <%@include file="createFaculty.jsp"%>
            </c:when>
            <c:when test="${nav == 7}">
                <%@include file="createSubject.jsp"%>
            </c:when>
            <c:when test="${nav == 8}">
                <%@include file="createSpeciality.jsp"%>
            </c:when>
            <c:otherwise>
                Не выбрано ни одно условие.
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>
