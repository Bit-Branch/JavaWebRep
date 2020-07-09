<%@ include file="head.jspf" %>
<%@include file="header.jspf"%>

<section class="authorize" id="login">
    <form action="${ pageContext.servletContext.contextPath }/register" method="POST">
        <input type="hidden" name="command" value="sign_up"/><br/>

        <input name="surname" type="text" placeholder="<fmt:message key="label.surname" bundle="${lang}"/>"
               required
               pattern="^[А-Я][а-яё]+$"
               title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>

        <input name="name" type="text" placeholder="<fmt:message key="label.name" bundle="${lang}"/>"
               required
               pattern="^[А-Я][а-яё]+$"
               title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>

        <input name="patronymic" type="text" placeholder="<fmt:message key="label.patronymic" bundle="${lang}"/>"
               required
               pattern="^[А-Я][а-яё]+$"
               title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>

        <input name="passport_number" type="text" placeholder="<fmt:message key="label.passportNumber" bundle="${lang}"/>"
               required
               pattern="^[А-Я]{2}\d{7}$"
               title="<fmt:message key="title.passport" bundle="${lang}"/>"/><br/>

        <input name="email" type="email" placeholder="<fmt:message key="label.email" bundle="${lang}"/>"
               required
               pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"
               title="<fmt:message key="title.email" bundle="${lang}"/>"/><br/>


        <input type="text" name="login" placeholder="<fmt:message key="label.login" bundle="${lang}"/>"
               pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
               title="<fmt:message key="title.login" bundle="${lang}"/>"
               required/><br/>

        <input type="password" class="pass" name="password" placeholder="<fmt:message key="label.password" bundle="${lang}"/>"
               pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"
               title="<fmt:message key="title.password" bundle="${lang}"/>"
               required/><br/>

        <input type="submit" value="<fmt:message key="label.register" bundle="${lang}"/>"/>
    </form>

<%--    <a href="${ pageContext.servletContext.contextPath }/jsp/register.jsp">--%>
<%--        <fmt:message key="label.register" bundle="${lang}"/><br>--%>
<%--    </a><br>--%>
</section>

<%@include file="footer.jspf"%>
<%@ include file="bottom.jspf" %>
