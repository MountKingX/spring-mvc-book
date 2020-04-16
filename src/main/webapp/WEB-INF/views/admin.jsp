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
    <title>Admin</title>
</head>
<body>
    <%@ include file="fragment/_naviBar.jsp" %>
    <div class="jumbotron">
        <div class="container">
            <h1> Admin Home, Welcome ${account.name}</h1>
            <div class="mt-4 pt-2">
                <div class="mt-3">
                    <h1>List of users</h1>
                </div>
                <div class="row my-3">
                    <c:forEach var="user" items="${users}">
                        <div class="col-sm-10">
                            <div class="card bg-light">
                                <div class="card-body align-content-stretch">
                                    <div class="card-title">
                                        <h3>Username: ${user.username}</h3>
                                    </div>
                                    <hr />
                                    <p>Name: ${user.name}</p>
                                    <p>Role: ${user.role}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="fragment/_footer.jsp" %>
    <%@ include file="fragment/_scripts-external-links.jsp" %>
</body>
</html>
