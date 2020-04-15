<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="fragment/_style-external-links.jsp" %>
    <link href='<spring:url value="/resources/css/my.css"/>' rel="stylesheet" />
    <title>Product Exception</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1 class="alert alert-danger"> There is no
                    product found with the Product id
                    ${invalidProductId}</h1>
            </div>
        </div>
    </section>
    <section>
        <div class="container">
            <p>${url}</p>
            <p>${exception}</p>
        </div>
        <div class="container">
            <p>
                <a href="<spring:url value="/market/products" />" class="btn btn-primary">
                    <i class="fas fa-arrow-left"></i> Back to Products Page
                </a>
            </p>
        </div>
    </section>
</body>
</html>
