<%@ include file="head.jspf" %>

<%@include file="header.jspf"%>

<div class="clever-catagory bg-img d-flex align-items-center justify-content-center p-3" style="background-image: url(img/bg-img/bg2.jpg);">
    <h3><fmt:message key="header.chooseFaculty" bundle="${lang}"/></h3>
</div>

<section class="popular-courses-area section-padding-100" data-pg-collapsed>
    <div class="container">
        <div class="row">

            <c:forEach var="faculty" items="${faculties}">


                <div class="col-12 col-md-6 col-lg-4" data-pg-collapsed>
                    <div class="single-popular-course mb-100 wow fadeInUp" data-wow-delay="250ms">
                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/c1.jpg" alt="">
                        <!-- Course Content -->
                        <div class="course-content">
                            <h4> #{faculty.getName()}</h4>
                            <p>#{faculty.getExamOne()}</p>
                            <p>#{faculty.getExamTwo()}</p>
                            <p>#{faculty.getExamThree()}</p>
                        </div>
                        <!-- Seat Rating Fee -->
                        <div class="seat-rating-fee d-flex justify-content-between">
                            <div class="seat-rating h-100 d-flex align-items-center">
                            </div>
                            <div class="course-fee h-100">
                                <a href="${ pageContext.servletContext.contextPath }/chooseFaculty?name=#{faculty.getName()}" class="free"><fmt:message key="label.choose" bundle="${lang}"/></a>
                            </div>
                        </div>
                    </div>
                </div>

            </c:forEach>

<%--            <div class="col-12 col-md-6 col-lg-4" data-pg-collapsed>--%>
<%--                <div class="single-popular-course mb-100 wow fadeInUp" data-wow-delay="500ms">--%>
<%--                    <img src="img/bg-img/c2.jpg" alt="">--%>
<%--                    <!-- Course Content -->--%>
<%--                    <div class="course-content">--%>
<%--                        <h4>Vocabulary</h4>--%>
<%--                        <div class="meta d-flex align-items-center">--%>
<%--                            <a href="#">Sarah Parker</a>--%>
<%--                            <span><i class="fa fa-circle" aria-hidden="true"></i></span>--%>
<%--                            <a href="#">Art &amp; Design</a>--%>
<%--                        </div>--%>
<%--                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce enim nulla, mollis eu metus in, sagittis</p>--%>
<%--                    </div>--%>
<%--                    <!-- Seat Rating Fee -->--%>
<%--                    <div class="seat-rating-fee d-flex justify-content-between">--%>
<%--                        <div class="seat-rating h-100 d-flex align-items-center">--%>
<%--                            <div class="seat">--%>
<%--                                <i class="fa fa-user" aria-hidden="true"></i> 10--%>
<%--                            </div>--%>
<%--                            <div class="rating">--%>
<%--                                <i class="fa fa-star" aria-hidden="true"></i> 4.5--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="course-fee h-100">--%>
<%--                            <a href="#">$20</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <!-- Single Popular Course -->--%>
<%--            <div class="col-12 col-md-6 col-lg-4" data-pg-collapsed>--%>
<%--                <div class="single-popular-course mb-100 wow fadeInUp" data-wow-delay="750ms">--%>
<%--                    <img src="img/bg-img/c3.jpg" alt="">--%>
<%--                    <!-- Course Content -->--%>
<%--                    <div class="course-content">--%>
<%--                        <h4>Expository writing</h4>--%>
<%--                        <div class="meta d-flex align-items-center">--%>
<%--                            <a href="#">Sarah Parker</a>--%>
<%--                            <span><i class="fa fa-circle" aria-hidden="true"></i></span>--%>
<%--                            <a href="#">Art &amp; Design</a>--%>
<%--                        </div>--%>
<%--                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce enim nulla, mollis eu metus in, sagittis</p>--%>
<%--                    </div>--%>
<%--                    <!-- Seat Rating Fee -->--%>
<%--                    <div class="seat-rating-fee d-flex justify-content-between">--%>
<%--                        <div class="seat-rating h-100 d-flex align-items-center">--%>
<%--                            <div class="seat">--%>
<%--                                <i class="fa fa-user" aria-hidden="true"></i> 10--%>
<%--                            </div>--%>
<%--                            <div class="rating">--%>
<%--                                <i class="fa fa-star" aria-hidden="true"></i> 4.5--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="course-fee h-100">--%>
<%--                            <a href="#">$45</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <!-- Single Popular Course -->
            <!-- Single Popular Course -->
            <!-- Single Popular Course -->
            <!-- Single Popular Course -->
            <!-- Single Popular Course -->
            <!-- Single Popular Course -->
        </div>
        <div class="row">
            <div class="col-12">
            </div>
        </div>
    </div>
</section>


<%@include file="footer.jspf"%>

<%@ include file="bottom.jspf" %>