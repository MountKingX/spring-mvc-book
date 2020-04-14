<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${contextPath}/webjars/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Welcome</title>
</head>
<body>
    <div class="jumbotron">
        <div class="container">
            <h1> ${greeting} </h1>
            <p> ${tagline} </p>
            <ul>
                <li>Click <a href="${contextPath}/customers" class="btn-secondary">here</a> to go to customers page</li>
                <li>Click <a href="${contextPath}/market/products" class="btn-success">here</a> to go to products page</li>
            </ul>
        </div>
    </div>
    <script src="${contextPath}/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="${contextPath}/webjars/popper.js/1.16.0/popper.min.js"></script>
    <script src="${contextPath}/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>
