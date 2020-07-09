<%@ include file="head.jspf" %>



<%@include file="header.jspf"%>

<section class="authorize" id="login">
    <form action="${ pageContext.servletContext.contextPath }/login" method="POST">
        <input type="hidden" name="command" value="login"/><br/>

        <input type="text" name="login" placeholder="<fmt:message key="label.login" bundle="${lang}"/>"
               pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
               title="<fmt:message key="title.login" bundle="${lang}"/>"
               required/><br/>

        <input type="password" class="pass" name="password" placeholder="<fmt:message key="label.password" bundle="${lang}"/>"
               pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"
               title="<fmt:message key="title.password" bundle="${lang}"/>"
               required/><br/>

        <input type="submit" value="<fmt:message key="label.signin" bundle="${lang}"/>"/>

    </form>
    <p id="message"><m:printMessage/></p>

<%--    <a href="${ pageContext.servletContext.contextPath }/jsp/register.jsp">--%>
<%--        <fmt:message key="label.register" bundle="${lang}"/><br>--%>
<%--    </a><br>--%>
</section>

<%@include file="footer.jspf"%>

<%@ include file="bottom.jspf" %>