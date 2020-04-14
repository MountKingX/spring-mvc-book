<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${contextPath}/webjars/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Add a Product</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Products</h1>
                <p>Add products</p>
            </div>
        </div>
    </section>
    <section class="container">
        <form:form method="POST" modelAttribute="newProduct"
                   class="form-horizontal" enctype="multipart/form-data">
            <fieldset>
                <legend>Add new product</legend>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code="addProduct.form.productId.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="productId" path="productId" type="text" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
                    <div class="col-lg-10">
                        <form:input id="name" path="name" type="text" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="unitPrice">Unit Price</label>
                    <div class="col-lg-10">
                        <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="manufacturer">Manufacturer</label>
                    <div class="col-lg-10">
                        <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="category">Category</label>
                    <div class="col-lg-10">
                        <form:input id="category" path="category" type="text" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Units In Stock</label>
                    <div class="col-lg-10">
                        <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
                    </div>
                </div>

<%--                <div class="form-group">--%>
<%--                    <label class="control-label col-lg-2 col-lg-2" for="unitsInOrder">Units In Order</label>--%>
<%--                    <div class="col-lg-10">--%>
<%--                        <form:input id="unitsInOrder" path="unitsInOrder" type="text" class="form:input-large"/>--%>
<%--                    </div>--%>
<%--                </div>--%>

                <div class="form-group">
                    <label class="control-label col-lg-2" for="description">Description</label>
                    <div class="col-lg-10">
                        <form:textarea id="description" path="description" rows = "2"/>
                    </div>
                </div>

<%--                <div class="form-group">--%>
<%--                    <label class="control-label col-lg-2" for="discontinued">Discontinued</label>--%>
<%--                    <span class="col-lg-10">--%>
<%--                        <form:checkbox id="discontinued" path="discontinued"/>--%>
<%--                    </span>--%>
<%--                </div>--%>

                <div class="form-group">
                    <%--@declare id="condition"--%>
                    <label class="control-label col-lg-2" for="condition">Condition</label>
                    <span class="col-lg-10">
                        <form:radiobutton path="condition" value="New" />New
                        <form:radiobutton path="condition" value="Old" />Old
                        <form:radiobutton path="condition" value="Refurbished" />Refurbished
                    </span>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2" for="productImage">
                        <spring:message code="addProduct.form.productImage.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </section>
</body>
</html>
