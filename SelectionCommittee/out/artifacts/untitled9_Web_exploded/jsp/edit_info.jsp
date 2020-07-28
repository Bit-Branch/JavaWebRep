<jsp:useBean id="address" scope="request" class="by.epam.committiee.entity.Address"/>
<jsp:useBean id="account" scope="request" class="by.epam.committiee.entity.Account"/>
<jsp:useBean id="user" scope="request" class="by.epam.committiee.entity.User"/>
<jsp:useBean id="errorMessage" scope="request" class="java.lang.String"/>
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
                                    <form>
                                        <div class="forms" data-pg-collapsed>
                                            <h4> <fmt:message key="label.personalCabinet" bundle="${lang}"/> </h4>


                                            <form action="${ pageContext.servletContext.contextPath }/edit_info?accountId=${account.id}&addressId=${address.id}" method="POST">
                                                <input type="hidden" name="command" value="edit_info"/><br/>


                                                <div class="row" data-pg-collapsed>
<%--                                                    <input type="file" name="photo" accept="image/*,image/jpeg">--%>


                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="instructor-thumb">
                                                            <img src="data:image/jpeg;base64,${image}" />
                                                        </div>
                                                        <a href="${ pageContext.servletContext.contextPath }/update_photo?command=update_photo" class="btn clever-btn"> <fmt:message key="label.update" bundle="${lang}"/></a>
                                                        <a href="${ pageContext.servletContext.contextPath }/delete_photo?command=delete_photo" class="btn clever-btn"> <fmt:message key="label.delete" bundle="${lang}"/></a>

                                                        <div class="form-group">
                                                        </div>
                                                    </div>

<%--                                                    <div class="col-12 col-lg-6" data-pg-collapsed>--%>
<%--&lt;%&ndash;                                                        <h5><fmt:message key="label.photo" bundle="${lang}"/></h5>&ndash;%&gt;--%>
<%--                                                        <div class="form-group">--%>
<%--                                                        </div>--%>
<%--                                                    </div>--%>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input type="file" name="photo" accept="image/*,image/jpeg">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.surname" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${user.surname}"
                                                                    name="surname" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.surname" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="<fmt:message key="rutextpattern" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.name" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${user.name}"
                                                                    name="name" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.name" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="<fmt:message key="rutextpattern" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                    <h5><fmt:message key="label.patronymic" bundle="${lang}"/></h5>
                                                    <div class="form-group">
                                                    </div>
                                                </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${user.patronymic}"
                                                                   name="patronymic" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.patronymic" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="<fmt:message key="rutextpattern" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.passportNumber" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${user.passportNumber}"
                                                                    name="passport_number" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.passportNumber" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="^[A-Z]{2}\d{7}$"
                                                                   title="<fmt:message key="title.passport" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.email" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${account.email}"
                                                                    name="email" class="form-control" type="email"
                                                                   placeholder="<fmt:message key="label.email" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"
                                                                   title="<fmt:message key="title.email" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.locality" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${address.locality}"
                                                                   name="locality" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.locality" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="<fmt:message key="rutextpattern" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.street" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${address.street}"
                                                                   name="street" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.street" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="<fmt:message key="rutextpattern" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.building" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${address.building}"
                                                                   name="building" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.building" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="[0-9]+"
                                                                   title="<fmt:message key="title.digitfield" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.flat" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${address.flat}"
                                                                   name="flat" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.flat" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="[0-9]+"
                                                                   title="<fmt:message key="title.digitfield" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.zipCode" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${address.zipCode}"
                                                                   name="zipCode" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.zipCode" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="[0-9]{6}"
                                                                   title="<fmt:message key="title.zipCode" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.login" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${account.login}"
                                                                    type="text" class="form-control" name="login"
                                                                   placeholder="<fmt:message key="label.login" bundle="${lang}"/>"
                                                                   pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$"
                                                                   title="<fmt:message key="title.login" bundle="${lang}"/>"
                                                                   required/><br/>

                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.password" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${account.password}"
                                                                    type="password" class="form-control pass" name="password"
                                                                   placeholder="<fmt:message key="label.password" bundle="${lang}"/>"
                                                                   pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"
                                                                   title="<fmt:message key="title.password" bundle="${lang}"/>"
                                                                   required/><br/>

                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <p style="color: red">${errorMessage}</p>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>

                                                    <div class="col-12">
                                                        <button class="btn clever-btn w-50"><fmt:message key="label.saveEdit" bundle="${lang}"/></button>
                                                    </div>
                                                </div>
                                            </form>
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

<%@include file="footer.jspf"%>
<%@ include file="bottom.jspf" %>
