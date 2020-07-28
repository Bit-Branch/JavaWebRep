<%@ include file="head.jspf" %>

<%@include file="header.jspf"%>


<section class="top-teacher-area section-padding-0-100">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="section-heading">
                    <h3><fmt:message key="header.chooseFaculty" bundle="${lang}"/></h3>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="col-12 col-md-6 col-lg-4">
                <div class="single-instructor d-flex align-items-center mb-30">
                    <div class="instructor-thumb">
                    </div>
                    <div class="instructor-info">
                        <a href="${ pageContext.servletContext.contextPath }/add_specialty?command=add_specialty" class="free"><fmt:message key="label.addSpecialty" bundle="${lang}"/></a>
                    </div>
                </div>
            </div>

            <jsp:useBean id="specialties" scope="request" type="java.util.List"/>
            <c:forEach var="specialty" items="${specialties}">

                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single-instructor d-flex align-items-center mb-30">
                        <div class="instructor-thumb">
                            <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t1.png" alt="">
                            <a href="${ pageContext.servletContext.contextPath }/delete_specialty?id=${specialty.getId()}&command=delete_specialty" class="free"><fmt:message key="label.delete" bundle="${lang}"/></a>

                        </div>
                        <div class="instructor-info">
                            <a href="${ pageContext.servletContext.contextPath }/show_specialty_info?id=${specialty.getId()}&command=show_specialty_info" class="free">${specialty.getName()}</a>
                            <span>${specialty.getPlan()}</span>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<%@include file="footer.jspf"%>

<%@ include file="bottom.jspf" %>