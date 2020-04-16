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
    <title>Register</title>
</head>
<body>
    <%@ include file="fragment/_naviBar.jsp" %>

    <%@ include file="./fragment/_flash_message.jsp" %>
    <!-- Register FORM -->
    <div class="container col-lg-5 col-md-6 col-sm-8 col-xsm-12 mt-2">
        <div class="card">
            <div class="card-header bg-dark text-white">
                <h3>New User Registration</h3>
            </div>
            <div class="card-body bg-light">
                <div class="remind text-left mx-2">
                    <p><b>(* all fields are required)</b></p>
                </div>
                <%--@elvariable id="user" type="User"--%>
                <form:form class="form-horizontal"
                           action="${contextPath}/account/register"
                           modelAttribute="user" method="POST">
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <label for="username"><i class="fas fa-user-circle"></i>&nbsp;Username</label><br>
                            <form:input class="form-control" type="text" path="username" required="required"
                                        name="username" id="username" value="${user.username}"/>
                            <form:errors path="username" cssClass="error" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-sm-12">
                            <label for="name">Full Name</label><br>
                            <form:input class="form-control" type="text" path="name" required="required"
                                        name="name" id="name" value="${user.name}"/>
                            <form:errors path="name" cssClass="error" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-sm-12">
                            <label for="password2"><i class="fas fa-key"></i>&nbsp;Password</label><br>
                            <form:input class="form-control" type="password" path="password" required="required"
                                        name="password2" id="password2"/>
                            <form:errors path="password2" cssClass="error" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-sm-12">
                            <label for="password2"><i class="fas fa-key"></i>&nbsp;Password Confirm</label><br>
                            <form:input class="form-control" type="password" path="password2" required="required"
                                        name="password2" id="password2"/>
                            <form:errors path="password2" cssClass="error" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-sm-12">
                            <input type="submit" name="registerButton"
                                   class="form-control btn btn-success btn-lg pull-right my-big-button"
                                   id="registerButton" value="Confirm Your Registration"/>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    <%@ include file="fragment/_footer.jsp" %>
    <%@ include file="fragment/_scripts-external-links.jsp" %>
</body>
</html>
