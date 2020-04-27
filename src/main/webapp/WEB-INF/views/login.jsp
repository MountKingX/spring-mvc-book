<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="fragment/_style-external-links.jsp" %>
    <link href='<spring:url value="/resources/css/my.css"/>' rel="stylesheet" />
    <title>Login Page</title>
</head>
<body>
    <%@ include file="fragment/_naviBar.jsp" %>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Welcome to Web Store!</h1>
                <p>The one and only amazing web store</p>
            </div>
        </div>
    </section>
    <%@ include file="./fragment/_flash_message.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please sign in here</h3>
                    </div>
                    <!-- LOGIN FORM -->
                    <div class="panel-body">
                        <c:url var="loginUrl" value="/login" />
                        <form action="${loginUrl}" method="post" class="form-horizontal">

                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Invalid username and password.</p>
                                </div>
                            </c:if>

                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>

                            <c:if test="${param.accessDenied != null}">
                                <div class="alert alert-danger">
                                    <p>Access Denied: You are not authorised! </p>
                                </div>
                            </c:if>

                            <div class="input-group input-md mb-3">
                                <label class="input-group-addon px-3 my-2" for="userId">
                                    <i class="fa fa-user"></i>
                                </label>
                                <input type="text" class="form-control" id="userId"
                                       name="userId" placeholder="Enter Username" required>
                            </div>
                            <div class="input-group input-md mb-3">
                                <label class="input-group-addon px-3 my-2" for="password">
                                    <i class="fa fa-lock"></i>
                                </label>
                                <input type="password" class="form-control" id="password" name="password"
                                       placeholder="Enter Password" required>
                            </div>

                            <div class="form-actions">
                                <input type="submit"
                                       class="btn btn-block btn-primary btn-default" value="Log in">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br /><br /><br /><br /><br /><br /><br /><br />
    <%@ include file="fragment/_footer.jsp" %>
    <%@ include file="fragment/_scripts-external-links.jsp" %>
</body>
</html>
