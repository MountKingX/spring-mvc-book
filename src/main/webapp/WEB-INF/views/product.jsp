<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${contextPath}/webjars/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Product Detail</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Products</h1>
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
                    <strong>manufacturer</strong> :
                    ${product.manufacturer}
                </p>
                <p>
                    <strong>category</strong> :
                    ${product.category}
                </p>
                <p>
                    <strong>Available units in stock </strong> :
                    ${product.unitsInStock}
                </p>
                <h4>${product.unitPrice} USD</h4>
                <p>
                    <a href="#" class="btn btn-warning btn-large">
                        <span class="glyphicon-shopping-cart glyphicon">
                        </span> Order Now
                    </a>
                </p>
            </div>
        </div>
    </section>
</body>
</html>
