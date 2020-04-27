<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="fragment/_style-external-links.jsp" %>
    <link href='<spring:url value="/resources/css/my.css"/>' rel="stylesheet" />
    <title>Admin Page</title>
</head>
<body>
    <%@ include file="fragment/_naviBar.jsp" %>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Welcome to Admin Page!</h1>
                <p>You can manage user here</p>
            </div>
        </div>
    </section>
    <%@ include file="./fragment/_flash_message.jsp" %>
    <div class="container">
        <security:authorize access="hasAnyRole('ADMIN')">
            This will only be displayed if authenticated user has role ROLE_ADMIN.
        </security:authorize>
    </div>
</body>
</html>
