
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
            <c:otherwise>
                Не выбрано ни одно условие.
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>
