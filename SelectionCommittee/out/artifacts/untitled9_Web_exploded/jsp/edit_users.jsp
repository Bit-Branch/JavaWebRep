<%@ include file="head.jspf" %>

<%@include file="header.jspf"%>


<section class="top-teacher-area section-padding-0-100">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="section-heading">
                    <h3><fmt:message key="header.chooseUser" bundle="${lang}"/></h3>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="col-12 col-md-6 col-lg-4">
                <div class="single-instructor d-flex align-items-center mb-30">
                    <div class="instructor-thumb">
                    </div>
                    <div class="instructor-info">
                        <a href="${ pageContext.servletContext.contextPath }/add_account?command=add_account" class="free"><fmt:message key="label.addAccount" bundle="${lang}"/></a>
                    </div>
                </div>
            </div>

<jsp:useBean id="accounts" scope="request" type="java.util.List"/>
<c:forEach var="account" items="${accounts}">

            <div class="col-12 col-md-6 col-lg-4">
                <div class="single-instructor d-flex align-items-center mb-30">
                    <div class="instructor-thumb">
                        <img src="${ pageContext.servletContext.contextPath }/img/bg-img/t1.png" alt="">
                    </div>
                    <div class="instructor-info">
                        <a href="${ pageContext.servletContext.contextPath }/choose_user?id=${account.getId()}&command=choose_user" class="free">${account.getLogin()}</a>
                        <span>${account.getRole().toString()}</span>
                        <span>  <a href="${ pageContext.servletContext.contextPath }/change_role?id=${account.getId()}&command=change_role" class="free"><fmt:message key="label.changeRole" bundle="${lang}"/></a></span>
                        <span>  <a href="${ pageContext.servletContext.contextPath }/delete_account?id=${account.getId()}&command=delete_account" class="free"><fmt:message key="label.delete" bundle="${lang}"/></a></span>
                    </div>
                </div>
            </div>
</c:forEach>
        </div>
    </div>
</section>

<%@include file="footer.jspf"%>

<%@ include file="bottom.jspf" %>