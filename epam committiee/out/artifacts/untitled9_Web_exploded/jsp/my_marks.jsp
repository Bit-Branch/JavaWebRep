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
                                        <div class="forms">
                                            <h4><fmt:message key="header.myMarks" bundle="${lang}"/></h4>
                                            <form action="${ pageContext.servletContext.contextPath }/editMarks" method="post">
                                                <div class="row" data-pg-collapsed>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <select name="subjectsSelect" class="subjectsSelect">
                                                            <c:forEach items="${subjects}" var="subject">
                                                                <option value="${subject}"><c:out value="${subject}" /></option>
                                                            </c:forEach>
                                                        </select>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" id="mark1" placeholder="<fmt:message key="label.mark" bundle="${lang}"/>">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <select name="subjectsSelect" class="subjectsSelect">
                                                            <c:forEach items="${subjects}" var="subject">
                                                                <option value="${subject}"><c:out value="${subject}" /></option>
                                                            </c:forEach>
                                                        </select>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" id="mark2" placeholder="<fmt:message key="label.mark" bundle="${lang}"/>">
                                                        </div>
                                                    </div>

                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <select name="subjectsSelect" class="subjectsSelect">
                                                            <c:forEach items="${subjects}" var="subject">
                                                                <option value="${subject}"><c:out value="${subject}" /></option>
                                                            </c:forEach>
                                                        </select>
                                                        <div class="form-group">
                                                        </div>
                                                    </div>
                                                    <div class="col-12 col-lg-6" data-pg-collapsed>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control" id="mark3" placeholder="<fmt:message key="label.mark" bundle="${lang}"/>">
                                                        </div>
                                                    </div>
                                                    <div class="col-12" data-pg-collapsed>
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