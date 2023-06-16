<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/25/2023
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sản phẩm</title>
</head>
<body>
<header>
    <%@include file="layout/header.jsp" %>
</header>

<section>
    <div class="container">
        <h1>Sản phẩm</h1>
        <form action="/san-pham/update?id=${sp.id}" method="post">
            <label>Mã</label>
            <input class="form-control" type="text" aria-label="default input example" name="ma" value="${sp.ma}">

            <label>Tên</label>
            <input class="form-control" type="text" aria-label="default input example" name="ten" value="${sp.ten}">

            <button type="submit" class="btn btn-success">Update</button>
        </form>
    </div>
</section>

<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
</html>
