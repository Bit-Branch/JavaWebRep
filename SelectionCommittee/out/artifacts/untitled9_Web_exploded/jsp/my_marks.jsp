<jsp:useBean id="result" scope="request" class="by.epam.committiee.entity.Result"/>
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

                                        <div class="forms">
                                            <h4><fmt:message key="header.myMarks" bundle="${lang}"/></h4>
                                            <form action="${ pageContext.servletContext.contextPath }/edit_marks" method="post">
                                                <input type="hidden" name="command" value="edit_marks"/><br/>

                                                <div class="row" data-pg-collapsed>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="header.math" bundle="${lang}"/></h5>
<%--                                                        <select name="subjectsSelect" class="subjectsSelect">--%>
<%--                                                            <jsp:useBean id="subjects" scope="request" type="java.util.List"/>--%>
<%--                                                            <c:forEach items="${subjects}" var="subject">--%>
<%--                                                                <option value="${subject}"><c:out value="${subject}" /></option>--%>
<%--                                                            </c:forEach>--%>
<%--                                                        </select>--%>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" name="mark1" id="mark1"
                                                                   required
                                                                   pattern="[0-9]+"
                                                                   title="<fmt:message key="title.digitfield" bundle="${lang}"/>"
                                                                   placeholder="<fmt:message key="label.mark" bundle="${lang}"/>"
                                                            value="${result.firstExamMark}">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="header.russian" bundle="${lang}"/></h5>
<%--                                                        <select name="subjectsSelect" class="subjectsSelect">--%>
<%--                                                            <c:forEach items="${subjects}" var="subject">--%>
<%--                                                                <option value="${subject}"><c:out value="${subject}" /></option>--%>
<%--                                                            </c:forEach>--%>
<%--                                                        </select>--%>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" name="mark2" id="mark2"
                                                                   required
                                                                   pattern="[0-9]+"
                                                                   title="<fmt:message key="title.digitfield" bundle="${lang}"/>"
                                                                   placeholder="<fmt:message key="label.mark" bundle="${lang}"/>"
                                                                   value="${result.secondExamMark}">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                    <h5><fmt:message key="header.physics" bundle="${lang}"/></h5>
                                                    <%--                                                        <select name="subjectsSelect" class="subjectsSelect">--%>
                                                    <%--                                                            <c:forEach items="${subjects}" var="subject">--%>
                                                    <%--                                                                <option value="${subject}"><c:out value="${subject}" /></option>--%>
                                                    <%--                                                            </c:forEach>--%>
                                                    <%--                                                        </select>--%>
                                                    <div class="form-group">
                                                    </div>
                                                </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" name="mark3" id="mark3"
                                                                   required
                                                                   pattern="[0-9]+"
                                                                   title="<fmt:message key="title.digitfield" bundle="${lang}"/>"
                                                                   placeholder="<fmt:message key="label.mark" bundle="${lang}"/>"
                                                                   value="${result.thirdExamMark}">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="header.english" bundle="${lang}"/></h5>
                                                <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" name="mark4" id="mark4" required
                                                                   pattern="[0-9]+"
                                                                   title="<fmt:message key="title.digitfield" bundle="${lang}"/>"
                                                                   placeholder="<fmt:message key="label.mark" bundle="${lang}"/>"
                                                                   value="${result.fourthExamMark}">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <h5><fmt:message key="header.certificate" bundle="${lang}"/></h5>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" name="certificateMark" id="certificateMark" required
                                                                   pattern="[0-9]+"
                                                                   title="<fmt:message key="title.digitfield" bundle="${lang}"/>"
                                                                   placeholder="<fmt:message key="label.mark" bundle="${lang}"/>"
                                                                   value="${result.certificateMark}">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <p style="color: red">${errorMessage}</p>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>

                                                    <div class="col-12" data-pg-collapsed>
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