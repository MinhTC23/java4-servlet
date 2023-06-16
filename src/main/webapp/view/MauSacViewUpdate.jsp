<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/25/2023
  Time: 12:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Màu sắc</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/home.css">
</head>
<body>
<header>
    <%@include file="layout/header.jsp" %>
</header>

<section>
    <div class="container">
        <h1>Màu sắc</h1>
        <form action="/mau-sac/update?id=${ms.id}" method="post">
            <label>Mã</label>
            <input class="form-control" type="text" aria-label="default input example" name="ma" value="${ms.ma}">

            <label>Tên</label>
            <input class="form-control" type="text" aria-label="default input example" name="ten" value="${ms.ten}">

            <button type="submit" class="btn btn-success">Update</button>
        </form>
    </div>
</section>

<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
</html>
