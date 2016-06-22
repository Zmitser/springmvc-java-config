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
    <div class="row column text-center">
        <h1>Blogposts</h1>
        <h2 class="subheader">Such a Simple Blog Layout</h2>
        <a href="<c:url value="/display-users"/>">Display Users</a>
        <a href="<c:url value="/newblogpost"/>">New Blog Post</a>
        <a href="<c:url value="/draft-blogposts"/>">Draft posts</a>
        <form action="<c:url value="/search-by-title"/>" method="post">
            <div class="row column log-in-form">
                <label>Title
                    <input type="text" name="title">
                </label>
                <p><button type="submit" class="button expanded">Search!</button></p>
            </div>
        </form>

    </div>
</div>
<c:if test="${empty blogposts}">
    No blogposts is not found
</c:if>
<!-- We can now combine rows and columns when there's only one column in that row -->
<div class="row medium-8 large-7 columns">
    <c:if test="${empty blogposts}">
        No blogposts is not found
    </c:if>
    <c:if test="${not empty blogposts}">
        <c:forEach items="${blogposts}" var="blogpost">
            <div class="blog-post">
                <h3>${blogpost.title}<small>${blogpost.publishDate}</small></h3>
                <img class="thumbnail" src="http://placehold.it/850x350">
                <p>${blogpost.content}</p>
                <div class="callout">
                    <ul class="menu simple">
                        <li><a href="#">Author: ${blogpost.user.username}</a></li>
                        <li><a href="#">Comments: 3</a></li>
                    </ul>
                </div>
            </div>
        </c:forEach>

    </c:if>

</div>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/foundation.min.js"/>"></script>
<script>
    $(document).foundation();
</script>
</body>
</html>