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
    <title>Customers</title>
</head>
<body>
    <%@ include file="fragment/_naviBar.jsp" %>
    <div class="container">
        <div class="mt-3">
            <h1>List of customers in our DB</h1>
        </div>
        <div class="row my-3">
            <c:forEach var="customer" items="${customers}">
                <div class="col-sm-10">
                    <div class="card bg-light">
                        <div class="card-body align-content-stretch">
                            <div class="card-title">
                                <h3>${customer.name}</h3>
                            </div>
                            <hr />
                            <p>Customer Id: ${customer.customerId}</p>
                            <p>Address: ${customer.address}</p>
                            <p>Notes: ${customer.noOfOrdersMade} orders have been made</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <ul class="mt-5">
            <li class="my-3">Click the right button to go to products page <a href="${contextPath}/market/products" class="btn-lg btn-success">View our Products</a> </li>
            <li class="my-3">Click the right button to go to Index page <a href="${contextPath}/" class="btn btn-secondary">Back to Index Page</a></li>
        </ul>
    </div>
    <%@ include file="fragment/_footer.jsp" %>
    <%@ include file="fragment/_scripts-external-links.jsp" %>
</body>
</html>
