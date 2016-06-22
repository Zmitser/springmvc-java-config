<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Admin page</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/foundation.min.css"/>">
    </head>
<body>
<!-- Start Top Bar -->
<div class="v_menu">
    <ul class="dropdown menu" data-dropdown-menu>
        <li><a href="#">HOMEPAGE</a></li>
        <li>
            <a href="#">${pageContext.response.locale}</a>
            <ul class="menu">
                <li><a href="/?language=en">EN</a></li>
                <li><a href="/?language=de">DE</a></li>
            </ul>
        </li>
        <li><a href="#">JSP</a></li>
        <li><a href="#">WEB SERVICE</a></li>
        <li><a href="#">HIBERNATE</a></li>
    </ul>
</div>

<!-- End Top Bar -->

<div class="callout large primary">
    <div class="row column text-center">
        <h1>Admin</h1>
        <h2 class="subheader">Such a Simple Blog Layout</h2>
        <a href="<c:url value="/display-users"/>">Display Users</a>
        <a href="<c:url value="/newblogpost"/>">New Blog Post</a>
        <a href="<c:url value="/blogposts"/>">Show</a>
    </div>
    <spring:message code="language"/><br>
    <spring:message code="welcome.text"/><br>
</div>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/foundation.min.js"/>"></script>
<script>
    $(document).foundation();
</script>
</body>
</html>

