<%@ include file="head.jspf" %>



<%@include file="header.jspf"%>

<section class="authorize" id="login">
    <form action="${ pageContext.servletContext.contextPath }/login" method="POST">
        <input type="hidden" name="command" value="login"/><br/>
        <input type="text" name="login" placeholder="<fmt:message key="label.login" bundle="${lang}"/>"
               pattern="^\w{5,20}"
               required/><br/>
        <input type="password" class="pass" name="password" placeholder="<fmt:message key="label.password" bundle="${lang}"/>"
               pattern="^(?=.*\d)(?=.*[a-zA-Z]).{10,}$"
               required/>
        <input type="submit" value="<fmt:message key="button.submit" bundle="${lang}"/>"/>
    </form>

    <a href="${ pageContext.servletContext.contextPath }/jsp/register.jsp">
        <fmt:message key="label.register" bundle="${lang}"/><br>
    </a><br>
</section>

<%@include file="footer.jspf"%>

<%@ include file="bottom.jspf" %>