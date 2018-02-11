<script src="/js/validation.js"></script>
<div class="form-position">
    ${entrant.getSurname()} ${entrant.getFirstName()} ${ entrant.getLastName()}
    <div class="title active">
    <i class="dropdown icon"></i>
        <table class="ui definition table">
            <thead>
            <tr><th></th>
                <th><fmt:message key="subject.label.subjectId"/></th>
                <th>балл</th>
            </tr></thead>

        <tbody>
        <c:forEach items="${ctpointEntrant}" var="ctpoint">
        <tr>
            <td>${ctpoint.getSubjectId()}</td>
            <td>${ctpoint.getScope()}</td>
        </tr>
        </c:forEach>
        </tbody></table>
    </div>
</div>