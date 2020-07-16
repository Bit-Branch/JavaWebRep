<%@ include file="head.jspf" %>

<%@include file="header.jspf"%>

<div class="single-course-intro d-flex align-items-center justify-content-center" style="background-image: url(img/bg-img/bg3.jpg);">
    <!-- Content -->
    <div class="single-course-intro-content text-center">
        <!-- Ratings -->
        <h3>English Grammar</h3>
        <div class="price">Факультет
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
                                <a class="nav-link active" id="tab--1" data-toggle="tab" href="#tab1" role="tab" aria-controls="tab1" aria-selected="false">Description</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="tab--4" data-toggle="tab" href="#tab4" role="tab" aria-controls="tab4" aria-selected="true">Members</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <!-- Tab Text -->
                            <div class="tab-pane fade show active" id="tab1" role="tabpanel" aria-labelledby="tab--1">
                                <div class="clever-description">
                                    <!-- About Course -->
                                    <div class="about-course mb-30">
                                        <h4>About this specialty</h4>
                                        <p>#{specialty.getDescription()}</p>
                                    </div>
                                    <!-- All Instructors -->
                                    <div class="all-instructors mb-30">
                                        <h4>All Instructors</h4>
                                        <div class="row">
                                            <!-- Single Instructor -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="img/bg-img/t1.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span>Teacher</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Instructor -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="img/bg-img/t2.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span>Teacher</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Instructor -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="img/bg-img/t3.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span>Teacher</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Instructor -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="img/bg-img/t4.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span>Teacher</span>
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
                                        <h4>Members</h4>
                                        <p>Sed elementum lacus a risus luctus suscipit. Aenean sollicitudin sapien neque, in fermentum lorem dignissim a. Nullam eu mattis quam. Donec porttitor nunc a diam molestie blandit. Maecenas quis ultrices</p>
                                    </div>
                                    <!-- All Members -->
                                    <div class="all-instructors mb-30">
                                        <div class="row">
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="img/bg-img/t1.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span>Teacher</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="img/bg-img/t2.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span>Teacher</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="img/bg-img/t3.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span>Teacher</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="img/bg-img/t4.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span>Teacher</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="img/bg-img/t1.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span>Teacher</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="img/bg-img/t2.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span>Teacher</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="img/bg-img/t3.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span>Teacher</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Single Members -->
                                            <div class="col-lg-6">
                                                <div class="single-instructor d-flex align-items-center mb-30">
                                                    <div class="instructor-thumb">
                                                        <img src="img/bg-img/t4.png" alt="">
                                                    </div>
                                                    <div class="instructor-info">
                                                        <h5>Sarah Parker</h5>
                                                        <span>Teacher</span>
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
                    <a href="${ pageContext.servletContext.contextPath }/enroll?name=#{specialty.getName()}" class="btn clever-btn mb-30 w-100">Записаться</a>
                    <!-- Widget -->
                    <div class="sidebar-widget">
                        <h4>Хар-ка:</h4>
                        <ul class="features-list">
                            <li>
                            </li>
                            <li data-pg-collapsed>
                                <h6><i class="fa fa-bell" aria-hidden="true"></i> План набота<br></h6>
                                <h6>#{specialty.getPlan()}</h6>
                            </li>
                            <li>
                                <h6><i class="fa fa-bell" aria-hidden="true"></i> Кол-во записавшихся<br></h6>
                                <h6>#{enrolleeCount}</h6>
                            </li>
                            <li>
                                <h6><i class="fa fa-file" aria-hidden="true"></i> Экзамен 1 (Математика) проходной балл</h6>
                                <h6>#{examOneMark}</h6>
                            </li>
                            <li>
                                <h6><i class="fa fa-file" aria-hidden="true"></i> Экзамен 1 (Математика) проходной балл</h6>
                                <h6>#{examTwoMark}</h6>
                            </li>
                            <li>
                                <h6><i class="fa fa-file" aria-hidden="true"></i> Экзамен 1 (Математика) проходной балл</h6>
                                <h6>#{examThreeMark}</h6>
                            </li>
                        </ul>
                    </div>
                    <!-- Widget -->
                    <div class="sidebar-widget">
                        <h4>Certification</h4>
                        <img src="img/bg-img/cer.png" alt="">
                    </div>
                    <!-- Widget -->
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jspf"%>

<%@ include file="bottom.jspf" %>
