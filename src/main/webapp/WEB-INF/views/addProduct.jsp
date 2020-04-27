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
    <title>Add a Product</title>
</head>
<body>
    <%@ include file="fragment/_naviBar.jsp" %>
    <section>
        <div class="jumbotron py-3">
            <div class="container">
                <h1>Add a New Product</h1>
                <section class="mt-3">
                    <div class="pull-right" style="padding-right:50px">
                        <h5>Language Choice:
                            <a href="?language=en" >English</a> | <a href="?language=nl" >Dutch</a>
                        </h5>
                    </div>
                </section>
            </div>
        </div>
    </section>
    <section class="container">
        <form:form method="POST" modelAttribute="newProduct"
                   class="form-horizontal" enctype="multipart/form-data">
            <form:errors path="*" cssClass="alert alert-danger" element="div"/>
            <fieldset>
                <div class="form-group row">
                    <label class="control-label col-lg-3" for="productId">
                        <spring:message code="addProduct.form.productId.label"/>
                    </label>
                    <div class="col-lg-9">
                        <form:input id="productId" path="productId" type="text" class="form:input-large"/>
                        <form:errors path="productId" cssClass="text-danger"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="control-label col-lg-3" for="name">
                        <spring:message code="addProduct.form.name.label"/>
                    </label>
                    <div class="col-lg-9">
                        <form:input id="name" path="name" type="text" class="form:input-large"/>
                        <form:errors path="name" cssClass="text-danger"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <label class="control-label col-lg-3" for="unitPrice">
                            <spring:message code="addProduct.form.unitPrice.label"/>
                        </label>
                        <div class="col-lg-9">
                            <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
                            <form:errors path="unitPrice" cssClass="text-danger"/>
                        </div>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="control-label col-lg-3" for="manufacturer">
                        <spring:message code="addProduct.form.manufacturer.label"/>
                    </label>
                    <div class="col-lg-9">
                        <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="control-label col-lg-3" for="category">
                        <spring:message code="addProduct.form.category.label"/>
                    </label>
                    <div class="col-lg-9">
                        <form:input id="category" path="category" type="text" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="control-label col-lg-3" for="unitsInStock">
                        <spring:message code="addProduct.form.unitsInStock.label"/>
                    </label>
                    <div class="col-lg-9">
                        <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="control-label col-lg-3" for="description">
                        <spring:message code="addProduct.form.description.label"/>
                    </label>
                    <div class="col-lg-9">
                        <form:textarea id="description" path="description" rows = "2"/>
                    </div>
                </div>

                <div class="form-group row">
                    <%--@declare id="condition"--%>
                    <label class="control-label col-lg-3" for="condition">
                        <spring:message code="addProduct.form.condition.label"/>
                    </label>
                    <span class="col-lg-9">
                        <form:radiobutton path="condition" value="New" />New
                        <form:radiobutton path="condition" value="Old" />Old
                        <form:radiobutton path="condition" value="Refurbished" />Refurbished
                    </span>
                </div>

                <div class="form-group row">
                    <label class="control-label col-lg-3" for="productImage">
                        <spring:message code="addProduct.form.productImage.label"/>
                    </label>
                    <div class="col-lg-9">
                        <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-offset-3 col-lg-9">
                        <input type="submit" id="btnAdd" class="btn bt-lg btn-success" value ="Submit Adding Request"/>
                    </div>
                </div>
            </fieldset>
        </form:form>
    </section>
    <%@ include file="fragment/_footer.jsp" %>
    <%@ include file="fragment/_scripts-external-links.jsp" %>
</body>
</html>
