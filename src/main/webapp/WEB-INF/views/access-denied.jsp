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
    <title>Access Denied</title>
</head>
<body>
    <%@ include file="fragment/_naviBar.jsp" %>
    <%@ include file="./fragment/_flash_message.jsp" %>

    <!-- HEADER -->
    <header id="main-header" class="py-2 mt-0 mb-3 text-white" style="background-color: #FA8072">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1><i class="fas fa-lock"></i> Access Denied</h1>
                </div>
            </div>
        </div>
    </header>
    <div class="container">
        <h2>Sorry - You are not authorized to perform this action</h2><hr>

        <!-- Flash message/error -->
        <%@ include file="./fragment/_flash_message.jsp" %>
    </div>
    <%@ include file="fragment/_footer.jsp" %>
    <%@ include file="fragment/_scripts-external-links.jsp" %>
</body>
</html>
