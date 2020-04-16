<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- check if any message-->
<%--@elvariable id="page_message" type="java.lang.String"--%>
<c:if test="${!(empty page_message)}">
    <section class="col-lg-12">
        <div class="text-center alert alert-success alert-dismissible col-sm-12">
            <button class="close" type="button" data-dismiss="alert">
                <span>&times;</span>
            </button>
            <i class="alert">${page_message}</i>
        </div>
    </section>
</c:if>

<!-- check if any error -->
<%--@elvariable id="page_error" type="java.lang.String"--%>
<c:if test="${!(empty page_error)}">
    <section class="col-lg-12">
        <div class="text-center alert alert-danger alert-dismissible col-sm-12">
            <button class="close" type="button" data-dismiss="alert">
                <span>&times;</span>
            </button>
            <i class="alert">${page_error}</i>
        </div>
    </section>
</c:if>
