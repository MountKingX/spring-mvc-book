<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Customers</title>
    <link rel="stylesheet" href="${contextPath}/webjars/bootstrap/4.4.1/css/bootstrap.min.css">
<%--    <link rel="stylesheet"--%>
<%--          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"--%>
<%--          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"--%>
<%--          crossorigin="anonymous">--%>
</head>
<body>
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
        <ul>
            <li>Click <a href="${contextPath}/" class="btn-primary">here</a> to go to index page</li>
            <li>Click <a href="${contextPath}/market/products" class="btn-success">here</a> to go to products page</li>
        </ul>
    </div>
    <script src="${contextPath}/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="${contextPath}/webjars/popper.js/1.16.0/popper.min.js"></script>
    <script src="${contextPath}/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>
