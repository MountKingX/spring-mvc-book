<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
            <security:authorize access="isAuthenticated()">
                <li class="nav-item active">
                    <a class="nav-link" href="${contextPath}/market/products">
                        <i class="fas fa-book"></i>&nbsp;Products
                    </a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="${contextPath}/market/customers">
                        <i class="fas fa-users"></i>&nbsp;Customers
                    </a>
                </li>
            </security:authorize>
            <security:authorize access="hasAnyRole('ADMIN')">
                <li class="nav-item active">
                    <a class="nav-link" href="${contextPath}/admin">
                        <i class="fas fa-dragon"></i>&nbsp;Admin
                    </a>
                </li>
            </security:authorize>
        </ul>

        <ul class="navbar-nav ml-auto">
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.authenticated}">
                    <li class="nav-item active">
                        <a class="nav-link" href="${contextPath}/market/cart">
                            <i class="fas fa-shopping-cart"></i>
                            &nbsp;Cart
                        </a>
                    </li>
                    <li class="nav-item active">
                        <a href="#" class="nav-link" onclick="document.getElementById('logout-form').submit();">
                            <i class="fas fa-power-off"></i>
                            &nbsp;Logout
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item active">
                        <a class="nav-link" href="${contextPath}/login">
                            <i class="fas fa-unlock-alt"></i>
                            &nbsp;Login
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
        <form:form method="POST" id="logout-form"
                   action="${contextPath}/logout">
        </form:form>
    </div>
</nav>