<jsp:useBean id="faculty" scope="request" class="by.epam.committiee.entity.Faculty"/>
<jsp:useBean id="errorMessage" scope="request" class="java.lang.String"/>
<%@ include file="head.jspf" %>
<%@include file="header.jspf"%>


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
                                            <h4> <fmt:message key="label.editing" bundle="${lang}"/> </h4>


                                            <form action="${ pageContext.servletContext.contextPath }/edit_faculty?id=${faculty.getId()}" method="POST">
                                                <input type="hidden" name="command" value="edit_faculty"/><br/>


                                                <div class="row" data-pg-collapsed>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.title" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${faculty.name}"
                                                                   name="name" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.title" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.examOne" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${faculty.examOne}"
                                                                   name="examOne" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.examOne" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.examTwo" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${faculty.examTwo}"
                                                                   name="examTwo" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.examTwo" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                    <h5><fmt:message key="label.examThree" bundle="${lang}"/></h5>
                                                    <div class="form-group">
                                                    </div>
                                                </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${faculty.examThree}"
                                                                   name="examThree" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.examThree" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.description" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <textarea value="${faculty.description}" name="description" class="form-control"
                                                                      placeholder="<fmt:message key="label.description" bundle="${lang}"/>"
                                                                      cols="30" rows="10"
                                                            required></textarea>
<%--                                                            <input value="${faculty.getDescription()}"--%>
<%--                                                                   name="examThree" class="form-control" type="text"--%>
<%--                                                                   placeholder="<fmt:message key="label.description" bundle="${lang}"/>"--%>
<%--                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/>--%>
                                                            <br/>
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
