<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="fragment/_style-external-links.jsp" %>
    <link href='<spring:url value="/resources/css/my.css"/>' rel="stylesheet" />
    <title>Login</title>
</head>
<body>
    <%@ include file="fragment/_naviBar.jsp" %>
    <%@ include file="./fragment/_flash_message.jsp" %>
    <!-- LOGIN FORM -->
    <div class="container col-lg-6 col-md-10 col-sm-12 col-xsm-12">
        <section id="login">
            <div class="my-4">
                <div class="row">
                    <div class="col-lg-6 col-md-8 col-sm-12 mx-auto">
                        <div class="card bg-dark">
                            <div class="card-header text-white">
                                <h4>Please Sign-In Here</h4>
                            </div>
                            <div class="card-body bg-light">
                                <form action="${contextPath}/account/login" method="POST">
                                    <div class="form-group">
                                        <i class="fas fa-user-circle"></i>&nbsp;
                                        <label for="username"><b>Username</b></label>
                                        <input id="username" name="username" type="text" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <i class="fas fa-key"></i>&nbsp;
                                        <label for="password"><b>Password</b></label>
                                        <input id="password" name="password" type="password" class="form-control">
                                    </div>
                                    <div class="mt-4">
                                        <input type="submit" value="Login" class="btn btn-dark btn-lg btn-block">
                                    </div>
                                    <div class="mt-4">
                                        <div class="d-flex justify-content-center links">
                                            Don't have an account?
                                            <a href="${contextPath}/account/register" class="ml-2">
                                                Sign Up</a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <br /><br />
    </div>
    <%@ include file="fragment/_footer.jsp" %>
    <%@ include file="fragment/_scripts-external-links.jsp" %>
</body>
</html>
