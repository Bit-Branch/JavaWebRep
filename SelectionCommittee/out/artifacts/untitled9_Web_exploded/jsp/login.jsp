<%@ include file="head.jspf" %>



<%@include file="header.jspf"%>

<%--<section class="authorize" id="login">--%>
<%--    <form action="${ pageContext.servletContext.contextPath }/login" method="POST">--%>
<%--        <input type="hidden" name="command" value="login"/><br/>--%>

<%--        <input type="text" name="login" placeholder="<fmt:message key="label.login" bundle="${lang}"/>"--%>
<%--               pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"--%>
<%--               title="<fmt:message key="title.login" bundle="${lang}"/>"--%>
<%--               required/><br/>--%>

<%--        <input type="password" class="pass" name="password" placeholder="<fmt:message key="label.password" bundle="${lang}"/>"--%>
<%--               pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"--%>
<%--               title="<fmt:message key="title.password" bundle="${lang}"/>"--%>
<%--               required/><br/>--%>

<%--        <input type="submit" value="<fmt:message key="label.signin" bundle="${lang}"/>"/>--%>

<%--    </form>--%>
<%--    <p id="message"><m:printMessage/></p>--%>

<%--&lt;%&ndash;    <a href="${ pageContext.servletContext.contextPath }/jsp/register.jsp">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <fmt:message key="label.register" bundle="${lang}"/><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </a><br>&ndash;%&gt;--%>
<%--</section>--%>
<jsp:useBean id="errorMessage" scope="request" class="java.lang.String"/>
<div class="regular-page-area section-padding-100" data-pg-collapsed>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="register-contact-form mb-100 wow fadeInUp" data-wow-delay="250ms">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-12" data-pg-collapsed>
                                <div class="page-content">

                                        <div class="forms" data-pg-collapsed>
                                            <h4> <fmt:message key="label.signin" bundle="${lang}"/> </h4>

                                            <form action="${ pageContext.servletContext.contextPath }/login" method="POST">

                                                <input type="hidden" name="command" value="sign_in"/><br/>

                                                <div class="row">

                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" name="login"
                                                                   placeholder="<fmt:message key="label.login" bundle="${lang}"/>"
                                                                   pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
                                                                   title="<fmt:message key="title.login" bundle="${lang}"/>"
                                                                   required/><br/>
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                            <input type="password" class="form-control pass" name="password"
                                                                   placeholder="<fmt:message key="label.password" bundle="${lang}"/>"
                                                                   pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"
                                                                   title="<fmt:message key="title.password" bundle="${lang}"/>"
                                                                   required/><br/>
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <p style="color: red">${errorMessage}</p>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>

                                                    <div class="col-12">
                                                        <button type="submit" class="btn clever-btn w-50" > <fmt:message key="label.signin" bundle="${lang}"/> </button>
                                                    </div>

                                                    <div class="col-12">
                                                        <%--    <a href="${ pageContext.servletContext.contextPath }/jsp/register.jsp">--%>
                                                        <%--        <fmt:message key="label.register" bundle="${lang}"/><br>--%>
                                                        <%--    </a><br>--%>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jspf"%>

<%@ include file="bottom.jspf" %>