<%@ include file="header.jspf" %>

<div class="content">
    <c:if test="${ sessionScope.User.role eq 'USER' }">
        <%@ include file="user.jspf" %>
    </c:if>
    <c:if test="${ sessionScope.User.role eq 'ADMIN' }">
        <%@ include file="admin.jspf" %>
    </c:if>
    <c:if test="${ empty sessionScope.User }">
        <jsp:forward page="/index.jsp"/>
    </c:if>
</div>
<%@ include file="footer.jspf" %>