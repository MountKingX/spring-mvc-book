<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${contextPath}/webjars/bootstrap/4.4.1/css/bootstrap.min.css">
    <!-- Font-awesome support v5.8.1-->
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.8.1/css/solid.css"
          integrity="sha384-QokYePQSOwpBDuhlHOsX0ymF6R/vLk/UQVz3WHa6wygxI5oGTmDTv8wahFOSspdm"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.8.1/css/brands.css"
          integrity="sha384-n9+6/aSqa9lBidZMRCQHTHKJscPq6NW4pCQBiMmHdUCvPN8ZOg2zJJTkC7WIezWv"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.8.1/css/fontawesome.css"
          integrity="sha384-vd1e11sR28tEK9YANUtpIOdjGW14pS87bUBuOIoBILVWLFnS+MCX9T6MMf0VdPGq"
          crossorigin="anonymous">

    <title>Products</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Products</h1>
                <p>All the available products in our store</p>
            </div>
        </div>
    </section>
    <section class="container">
        <div class="row">
            <c:forEach var="product" items="${products}">
                <div class="col-sm-6 col-md-3" style="padding-bottom: 15px;">
                    <div class="card bg-light">
                        <div class="card-header">
                            <img src="<c:url value="/resources/img/${product.productId}.png" />"
                                 alt="image" style="width:100%"/>
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
                                <a href=" <spring:url value="/market/product?id=${product.productId}" /> " class="btn btn-primary">
                                    <i class="fas fa-info"></i> Details
                                </a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="row mt-xl-5">
            <span class="mx-3 py-2">
                Click the button in the right to update stock for units < 500:
            </span>
            <a class="btn-warning btn-lg"
                href="${contextPath}/market/products/update/stock">
                Update +1000 units
            </a>
        </div>
        <div class="row mt-3">
            <span class="mx-3 py-2">
                 Click button in the right to add a item:
            </span>
            <a href="${contextPath}/market/products/add" class="btn-success btn-lg"> Add New Item </a>
        </div>
        <div class="row mt-3">
            <ul>
                <li>Click <a href="${contextPath}/" class="btn-primary">here</a> to go to index page</li>
                <li>Click <a href="${contextPath}/customers" class="btn-secondary">here</a> to go to customers page</li>
            </ul>
        </div>
    </section>
</body>
</html>
