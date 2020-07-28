<jsp:useBean id="specialty" scope="request" class="by.epam.committiee.entity.Specialty"/>
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
                                    <form>
                                        <div class="forms" data-pg-collapsed>
                                            <h4> <fmt:message key="label.register" bundle="${lang}"/> </h4>


                                            <form action="${ pageContext.servletContext.contextPath }/edit_specialty?id=${specialty.id}" method="POST">
                                                <input type="hidden" name="command" value="edit_specialty"/><br/>


                                                <div class="row" data-pg-collapsed>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.title" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${specialty.name}"
                                                                   name="name" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.title" bundle="${lang}"/>"
                                                                   title="<fmt:message key="title.textfield" bundle="${lang}"/>"/><br/>
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.plan" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input value="${specialty.plan}"
                                                                   name="plan" class="form-control" type="text"
                                                                   placeholder="<fmt:message key="label.plan" bundle="${lang}"/>"
                                                                   required
                                                                   pattern="[0-9]+"
                                                                   title="<fmt:message key="title.digitfield" bundle="${lang}"/>"/><br/>

                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.description" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <textarea value="${specialty.description}" name="description" class="form-control"
                                                                      placeholder="<fmt:message key="label.description" bundle="${lang}"/>"
                                                                      cols="30" rows="10"
                                                                      required></textarea>
                                                          <br/>
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="label.faculty" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <select name="faculties" class="btn" required>
                                                                <jsp:useBean id="faculties" scope="request" type="java.util.List"/>
                                                                <c:forEach items="${faculties}" var="faculty">
                                                                    <option value="${faculty.getId()}">
                                                                            ${faculty.getName()}
                                                                    </option>
                                                                </c:forEach>
                                                            </select>
<%--                                                            <input value="${specialty.getFacultyId()}"--%>
<%--                                                                   name="facultyId" class="form-control" type="text"--%>
<%--                                                                   placeholder="<fmt:message key="label.building" bundle="${lang}"/>"--%>
<%--                                                                   required--%>
<%--                                                                   pattern="[0-9]+"--%>
<%--                                                                   title="<fmt:message key="title.digitfield" bundle="${lang}"/>"/><br/>--%>

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
