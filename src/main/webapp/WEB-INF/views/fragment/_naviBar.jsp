<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-expand-md navbar-dark bg-dark pb-1 mb-0" id="main-nav">
    <a class="navbar-brand nav-item" href="${contextPath}/index">
        <i class="fas fa-seedling"></i>&nbsp;MVC-Book</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav mr-auto">
            <c:if test="${!(empty sessionScope.account) || !(empty sessionScope.admin)}">
                <li class="nav-item active">
                    <a class="nav-link" href="${contextPath}/market/products">
                        <i class="fas fa-book"></i>&nbsp;Products
                    </a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="${contextPath}/customers">
                        <i class="fas fa-users"></i>&nbsp;Customers
                    </a>
                </li>
            </c:if>
            <c:if test="${!(empty sessionScope.admin)}">
                <li class="nav-item active">
                    <a class="nav-link" href="${contextPath}/private/admin">
                        <i class="fas fa-user-tie"></i>&nbsp;Admin
                    </a>
                </li>
            </c:if>
            <form:form method="POST" id="logout-form"
                       action="${contextPath}/account/logout">
            </form:form>
        </ul>

        <ul class="navbar-nav ml-auto">
            <c:if test="${!(empty sessionScope.account) || !(empty sessionScope.admin)}">
                <li class="nav-item active">
                    <a href="#" class="nav-link" onclick="document.getElementById('logout-form').submit();">
                        <i class="fas fa-power-off"></i>
                        &nbsp;Logout
                    </a>
                </li>
            </c:if>
            <c:if test="${(empty sessionScope.account) && (empty sessionScope.admin)}">
                <li class="nav-item active">
                    <a class="nav-link" href="${contextPath}/account/login">
                        <i class="fas fa-unlock-alt"></i>
                        &nbsp;Login
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="${contextPath}/account/register">
                        <i class="fas fa-unlock-alt"></i>
                        &nbsp;Register
                    </a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>