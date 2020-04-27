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
    <title>Welcome</title>
</head>
<body>
    <%@ include file="fragment/_naviBar.jsp" %>
    <%@ include file="./fragment/_flash_message.jsp" %>
    <div class="jumbotron">
        <div class="container">
            <h1> ${greeting} </h1>
            <p> ${tagline} </p>
            <div class="mt-4 pt-2">
                <h5>Primary links</h5>
                <ul class="mt-2">
                    <li class="my-3">Click the right button to go to products page <a href="${contextPath}/market/products" class="btn-lg btn-success">View our products</a> </li>
                    <li class="my-3">Click the right button to go to customers page <a href="${contextPath}/customers" class="btn-lg btn-primary">View our Customers</a></li>
                </ul>
            </div>
            <div class="mt-4 pt-2">
                <h5>Testing Promotions</h5>
                <div class="mt-3">
                    View incorrect promotion offer :
                    <a href="${contextPath}/market/products/specialOffer?promo=offer" class="btn-danger btn-lg"> promo=offer </a>
                </div>
                <div class="mt-3">
                    View correct promotion offer :
                    <a href="${contextPath}/market/products/specialOffer?promo=OFF3R" class="btn-info btn-lg"> promo=OFF3R </a>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="fragment/_footer.jsp" %>
    <%@ include file="fragment/_scripts-external-links.jsp" %>
</body>
</html>
