<jsp:useBean id="errorMessage" scope="request" class="java.lang.String"/>
<jsp:useBean id="examThreeMark" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="examTwoMark" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="examOneMark" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="enrolleeCount" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="specialty" scope="request" class="by.epam.committiee.entity.Specialty"/>
<jsp:useBean id="faculty" scope="request" class="by.epam.committiee.entity.Faculty"/>
<%@ include file="head.jspf" %>

<%@include file="header.jspf"%>

<div class="single-course-intro d-flex align-items-center justify-content-center" style="background-image: url(${ pageContext.servletContext.contextPath }/img/bg-img/bg3.jpg);">
    <!-- Content -->
    <div class="single-course-intro-content text-center">
        <!-- Ratings -->
        <h3>${specialty.name}</h3>
        <div class="price">${faculty.name}
            <br>
        </div>
    </div>
</div>

<div class="single-course-content section-padding-100" data-pg-collapsed>
    <div class="container">
        <div class="row">
            <div class="col-12 col-lg-8">
                <div class="course--content" data-pg-collapsed>
                    <div class="clever-tabs-content">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="tab--1" data-toggle="tab" href="#tab1" role="tab" aria-controls="tab1" aria-selected="false">
                                    <fmt:message key="label.description" bundle="${lang}"/>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="tab--4" data-toggle="tab" href="#tab4" role="tab" aria-controls="tab4" aria-selected="true">
                                    <fmt:message key="label.teachers" bundle="${lang}"/>
                                </a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <!-- Tab Text -->
                            <div class="tab-pane fade show active" id="tab1" role="tabpanel" aria-labelledby="tab--1">
                                <div class="clever-description">
                                    <!-- About Course -->
                                    <div class="about-course mb-30">
                                        <h4><fmt:message key="header.aboutThisSpecialty" bundle="${lang}"/></h4>
                                        <p>${specialty.description}</p>
                                    </div>
                                    <!-- All Instructors -->
                                    <div class="all-instructors mb-30">
                                        <h4><fmt:message key="header.allTeachers" bundle="${lang}"/></h4>
                                        <div class="row">
                                            <!-- Single Instructor -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t1.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span><fmt:message key="label.teacher" bundle="${lang}"/></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Instructor -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t2.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span><fmt:message key="label.teacher" bundle="${lang}"/></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Instructor -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t3.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span><fmt:message key="label.teacher" bundle="${lang}"/></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Instructor -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t4.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span><fmt:message key="label.teacher" bundle="${lang}"/></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- FAQ -->
                                </div>
                            </div>
                            <div class="tab-pane fade" id="tab4" role="tabpanel" aria-labelledby="tab--4">
                                <div class="clever-members">
                                    <!-- About Members -->
                                    <div class="about-members mb-30">
                                        <h4><fmt:message key="header.teachers" bundle="${lang}"/></h4>
                                        </div>
                                    <!-- All Members -->
                                    <div class="all-instructors mb-30">
                                        <div class="row">
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t1.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span><fmt:message key="label.teacher" bundle="${lang}"/></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t2.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span><fmt:message key="label.teacher" bundle="${lang}"/></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t3.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span><fmt:message key="label.teacher" bundle="${lang}"/></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t4.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span><fmt:message key="label.teacher" bundle="${lang}"/></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t1.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span><fmt:message key="label.teacher" bundle="${lang}"/></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t2.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span><fmt:message key="label.teacher" bundle="${lang}"/></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t3.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span><fmt:message key="label.teacher" bundle="${lang}"/></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t4.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span><fmt:message key="label.teacher" bundle="${lang}"/></span>
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
            </div>
            <div class="col-12 col-lg-4">
                <div class="course-sidebar">
                    <!-- Buy Course -->
                    <a href="${ pageContext.servletContext.contextPath }/enroll?id=${specialty.id}" class="btn clever-btn mb-30 w-100">
                        <fmt:message key="label.enroll" bundle="${lang}"/>
                    </a>
                    <p style="color: red">${errorMessage}</p>
                    <!-- Widget -->
                    <div class="sidebar-widget">
                        <h4><fmt:message key="header.characteristics" bundle="${lang}"/></h4>
                        <ul class="features-list">
                            <li>
                            </li>
                            <li data-pg-collapsed>
                                <h6><i class="fa fa-bell" aria-hidden="true"></i>
                                    <fmt:message key="header.plan" bundle="${lang}"/>
                                    <br></h6>
                                <h6>${specialty.plan}</h6>
                            </li>
                            <li>
                                <h6><i class="fa fa-bell" aria-hidden="true"></i>
                                    <fmt:message key="header.enrolledCount" bundle="${lang}"/><br></h6>
                                <h6>${enrolleeCount}</h6>
                            </li>
                            <li>
                                <h6><i class="fa fa-file" aria-hidden="true"></i>
                                ${faculty.examOne}</h6>
                                <h6>${examOneMark}</h6>
                            </li>
                            <li>
                                <h6><i class="fa fa-file" aria-hidden="true"></i>
                                ${faculty.examTwo}</h6>
                                <h6>${examTwoMark}</h6>
                            </li>
                            <li>
                                <h6><i class="fa fa-file" aria-hidden="true"></i>
                                ${faculty.examThree}</h6>
                                <h6>${examThreeMark}</h6>
                            </li>
                        </ul>
                    </div>
                    <!-- Widget -->
                    <div class="sidebar-widget">
                        <h4><fmt:message key="header.certification" bundle="${lang}"/></h4>
                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/cer.png" alt="">
                    </div>
                    <!-- Widget -->
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jspf"%>

<%@ include file="bottom.jspf" %>
