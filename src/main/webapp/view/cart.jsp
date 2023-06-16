<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<header>
    <%@include file="layout/header.jsp" %>
</header>
<div class="container">
    <h1>Giỏ hàng</h1>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá Bán</th>
            <th>Thành Tiền</th>
        </tr>
        <c:forEach var="items" items="${cart.items}">
            <tr>
                <td>${items.productId}</td>
                <td>${items.productName}</td>
                <td>${items.quantity}</td>
                <td><b>$${items.price}</b></td>
                <td><b>$${items.quantity *items.price}</b></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/trang-chu/hien-thi" role="button" class="btn btn-outline-success">Tiếp tục mua hàng</a>
</div>
<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
</html>