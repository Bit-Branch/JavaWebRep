<%@ include file="head.jspf" %>
<%@include file="header.jspf"%>

<%--<section class="authorize" id="login">--%>
<%--    <form action="${ pageContext.servletContext.contextPath }/register" method="POST">--%>
<%--        <input type="hidden" name="command" value="sign_up"/><br/>--%>

<%--        <input name="surname" type="text" placeholder="<fmt:message key="label.surname" bundle="${lang}"/>"--%>
<%--               required--%>
<%--               pattern="^[А-Я][а-яё]+$"--%>
<%--               title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>--%>

<%--        <input name="name" type="text" placeholder="<fmt:message key="label.name" bundle="${lang}"/>"--%>
<%--               required--%>
<%--               pattern="^[А-Я][а-яё]+$"--%>
<%--               title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>--%>

<%--        <input name="patronymic" type="text" placeholder="<fmt:message key="label.patronymic" bundle="${lang}"/>"--%>
<%--               required--%>
<%--               pattern="^[А-Я][а-яё]+$"--%>
<%--               title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>--%>

<%--        <input name="passport_number" type="text" placeholder="<fmt:message key="label.passportNumber" bundle="${lang}"/>"--%>
<%--               required--%>
<%--               pattern="^[А-Я]{2}\d{7}$"--%>
<%--               title="<fmt:message key="title.passport" bundle="${lang}"/>"/><br/>--%>

<%--        <input name="email" type="email" placeholder="<fmt:message key="label.email" bundle="${lang}"/>"--%>
<%--               required--%>
<%--               pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"--%>
<%--               title="<fmt:message key="title.email" bundle="${lang}"/>"/><br/>--%>


<%--        <input type="text" name="login" placeholder="<fmt:message key="label.login" bundle="${lang}"/>"--%>
<%--               pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"--%>
<%--               title="<fmt:message key="title.login" bundle="${lang}"/>"--%>
<%--               required/><br/>--%>

<%--        <input type="password" class="pass" name="password" placeholder="<fmt:message key="label.password" bundle="${lang}"/>"--%>
<%--               pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"--%>
<%--               title="<fmt:message key="title.password" bundle="${lang}"/>"--%>
<%--               required/><br/>--%>

<%--        <input type="submit" value="<fmt:message key="label.register" bundle="${lang}"/>"/>--%>
<%--    </form>--%>

<%--&lt;%&ndash;    <a href="${ pageContext.servletContext.contextPath }/jsp/register.jsp">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <fmt:message key="label.register" bundle="${lang}"/><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </a><br>&ndash;%&gt;--%>
<%--</section>--%>

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
                                            <h4> <fmt:message key="label.register" bundle="${lang}"/> </h4>


                                            <form action="${ pageContext.servletContext.contextPath }/register" method="POST">
                                                <input type="hidden" name="command" value="sign_up"/><br/>


                                                <div class="row">

                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                            <input name="surname" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.surname" bundle="${lang}"/>"

                                                                   pattern="<fmt:message key="rutextpattern" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>" required/><br/>
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                            <input name="name" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.name" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="<fmt:message key="rutextpattern" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                            <input name="patronymic" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.patronymic" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="<fmt:message key="rutextpattern" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                            <input name="passport_number" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.passportNumber" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="^[A-Z]{2}\d{7}$"
                                                                   title="<fmt:message key="title.passport" bundle="${lang}"/>"/><br/>
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                            <input name="email" class="form-control" type="email"
                                                                   placeholder="<fmt:message key="label.email" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"
                                                                   title="<fmt:message key="title.email" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6">
                                                        <div class="form-group">
                                                        </div>
                                                    </div>

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

                                                    <div class="col-12">
                                                        <button type="submit" class="btn clever-btn w-50" > <fmt:message key="label.register" bundle="${lang}"/> </button>
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
