<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 19.06.2016
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Welcome</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/foundation.min.css"/>">
</head>
<body>
<!-- Start Top Bar -->
<div class="v_menu">
    <ul class="dropdown menu" data-dropdown-menu>
        <li><a href="#">HOMEPAGE</a></li>
        <li><a href="#">${pageContext.response.locale}</a>
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
    <c:if test="${not empty message}">
        ${message}<br>
    </c:if>
    <div class="row column text-center">
        <h1>New Blog Post</h1>
        <div class="row">
            <div class="medium-6 medium-centered large-4 large-centered columns">
                <form action="<c:url value="/save-post"/>" method="post">
                    <div class="row column log-in-form">
                        <label>Title
                            <input type="text" name="title">
                        </label>
                        <label>Content
                            <textarea name="content" id="content" cols="30" rows="10"></textarea>
                        </label>
                        <input id="show-password" name="draft" type="checkbox"><label for="show-password">Draft</label>
                        <p><button type="submit" class="button expanded">Log In</button></p>
                    </div>
                </form>

            </div>
        </div>
        <a href="<c:url value="/"/>">Back</a>
        <a href="<c:url value="/blogposts"/>">Show all blog posts</a>
    </div>
</div>


<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/foundation.min.js"/>"></script>
<script>
    $(document).foundation();
</script>
</body>
</html>
