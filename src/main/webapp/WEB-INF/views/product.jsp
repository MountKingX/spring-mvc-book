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
    <title>Product Detail</title>
</head>
<body>
    <%@ include file="fragment/_naviBar.jsp" %>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Product Item</h1>
            </div>
        </div>
    </section>
    <section class="container">
        <div class="row">
            <div class="col-md-5">
                <img src="<c:url value="${contextPath}/resources/img/${product.productId}.png" />"
                     alt="image" style="width:100%"/>
            </div>
            <div class="col-md-5">

                <h3>${product.name}</h3>
                <p>${product.description}</p>
                <p>
                    <strong>Item Code : </strong><span
                        class="badge badge-warning">${product.productId}
                </span>
                </p>
                <p>
                    <strong>Manufacturer</strong> :
                    ${product.manufacturer}
                </p>
                <p>
                    <strong>Category</strong> :
                    ${product.category}
                </p>
                <p>
                    <strong>Available units in stock </strong> :
                    ${product.unitsInStock}
                </p>
                <h4>${product.unitPrice} USD</h4>
                <p>
                    <a href="${contextPath}/market/products"
                        class="btn btn-success btn-md">
                        <i class="fas fa-arrow-left"></i> Back</a>
                    <a href="#" class="btn btn-warning btn-md">
                        <i class="fas fa-shopping-cart"></i> Order Now
                    </a>
                </p>
            </div>
        </div>
    </section>
    <%@ include file="fragment/_footer.jsp" %>
    <%@ include file="fragment/_scripts-external-links.jsp" %>
</body>
</html>
