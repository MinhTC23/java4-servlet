<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/25/2023
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nhà sản xuất</title>
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
    <%@include file="layout/header.jsp"%>
</header>

<section>
    <div class="container">
        <h1>Nhà sản xuất</h1>
        <form action="/nha-san-xuat/add" method="post">
            <label>Mã</label>
            <input class="form-control" type="text" aria-label="default input example" name="ma">

            <label>Tên</label>
            <input class="form-control" type="text" aria-label="default input example" name="ten">

            <button type="submit" class="btn btn-success">Add</button>
        </form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="nsx">
                <tr>
                    <td>${nsx.id}</td>
                    <td>${nsx.ma}</td>
                    <td>${nsx.ten}</td>
                    <td>
                        <a href="/nha-san-xuat/detail?id=${nsx.id}" class="btn btn-success" role="button">Detail</a>
                        <a href="/nha-san-xuat/delete?id=${nsx.id}" class="btn btn-success" role="button">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<footer>
    <%@include file="layout/footer.jsp"%>
</footer>
</body>
</html>
