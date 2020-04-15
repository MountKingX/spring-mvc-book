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
    <title>Products</title>
</head>
<body>
    <%@ include file="fragment/_naviBar.jsp" %>
    <section>
        <div class="jumbotron mb-2 py-3">
            <div class="container">
                <h1>Products</h1>
                <p>All the available products in our store</p>
                <div class="row mt-2">
                    <span class="mx-3 pt-2">
                         Click button in the right to add a item:
                    </span>
                    <a href="${contextPath}/market/products/add" class="btn-success btn-lg"> Add a New Item </a>
                </div>
            </div>
        </div>
    </section>
    <c:if test="${!(empty page_message)}">
        <div class="alert alert-success alert-dismissible col-sm-12 text-center">
            <button class="close" type="button" data-dismiss="alert">
                <span>&times;</span>
            </button>
            <i class="alert">${page_message}</i>
        </div>
    </c:if>
    <section class="container">
        <div class="row">
            <c:forEach var="product" items="${products}">
                <div class="col-sm-6 col-md-4 col-lg-3" style="padding-bottom: 15px;">
                    <div class="card bg-light">
                        <div class="card-header">
                            <img src="<c:url value="/resources/img/${product.productId}.png" />"
                                 alt="image" style="width: 100%; max-height: 160px"/>
                        </div>
                        <div class="card-body align-content-stretch">
                            <div class="card-title">
                                <h3>${product.name}</h3>
                            </div>
                            <hr />
                            <p style="min-height: 100px;">${product.description}</p>
                            <p>${product.unitPrice} USD</p>
                            <p>Available <b>${product.unitsInStock}</b> units in stock</p>
                            <p>
                                <a href=" <spring:url value="/market/product?id=${product.productId}" /> " class="btn btn-info">
                                    <i class="fas fa-info"></i> Details
                                </a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="row mt-2">
            <span class="mx-3 py-2">
                Click the button in the right to update stock for units < 500:
            </span>
            <form:form method="POST" action="${contextPath}/market/products/update/stock">
                <input type="submit"
                       class="btn-warning btn-lg"
                       value="Update +1000 units">
            </form:form>
        </div>
        <div class="row mt-4">
            <ul class="mt-2">
                <li class="my-3">Click the right button to go to customers page <a href="${contextPath}/customers" class="btn-lg btn-primary">View our Customers</a></li>
                <li class="my-3">Click the right button to go to Index page <a href="${contextPath}/" class="btn btn-secondary">Back to Index Page</a></li>
            </ul>
        </div>
    </section>
    <%@ include file="fragment/_footer.jsp" %>
    <%@ include file="fragment/_scripts-external-links.jsp" %>
</body>
</html>
