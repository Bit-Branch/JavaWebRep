<%@ include file="head.jspf" %>

<%@include file="header.jspf"%>
<jsp:useBean id="creditedId" scope="request" type="java.lang.Integer"/>


<div class="clever-catagory bg-img d-flex align-items-center justify-content-center p-3" style="background-image: url(${ pageContext.servletContext.contextPath }/img/bg-img/bg2.jpg);">
    <h3><fmt:message key="header.mySpecialties" bundle="${lang}"/></h3>
</div>

<section class="popular-courses-area section-padding-100" data-pg-collapsed>
    <div class="container">
        <div class="row">

            <jsp:useBean id="specialties" scope="request" type="java.util.List"/>

            <c:if test="${specialties.size() == 0}">
                <h1><fmt:message key="header.thereAreNoSpecialties" bundle="${lang}"/></h1>
            </c:if>

            <c:forEach var="specialty" items="${specialties}">


                <div class="col-12 col-md-6 col-lg-4" data-pg-collapsed>
                    <div class="single-popular-course mb-100 wow fadeInUp" data-wow-delay="500ms">
                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/c2.jpg" alt="">
                        <!-- Course Content -->
                        <div class="course-content">
                            <h4>${specialty.getName()}</h4>
                            <p>${specialty.getDescription().substring(0,10) + "..."}</p>
                        </div>
                        <!-- Seat Rating Fee -->
                        <div class="seat-rating-fee d-flex justify-content-between">
                            <div class="seat-rating h-100 d-flex align-items-center">
                                <div class="seat">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                        ${specialty.getPlan()}
                                </div>
                                <p>Status:
                                    <c:choose>
                                        <c:when test="${specialty.getId() == creditedId}">
                                            <fmt:message key="label.credited" bundle="${lang}"/>
                                        </c:when>
                                        <c:otherwise>
                                            <fmt:message key="label.notCredited" bundle="${lang}"/>
                                        </c:otherwise>
                                    </c:choose>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>
        <div class="row">
            <div class="col-12">
            </div>
        </div>
    </div>
</section>


<%@include file="footer.jspf"%>

<%@ include file="bottom.jspf" %>