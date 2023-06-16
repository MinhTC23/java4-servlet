<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/26/2023
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
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
        <h1>Chi tiết sản phẩm</h1>
        <form action="/chi-tiet-san-pham/update?id=${ctsp.id}" method="post">
            <label>ID Sản phẩm</label>
            <select class="form-select" aria-label="Default select example" name="idSP">
                <option value="${ctsp.sanPham.id}">${ctsp.sanPham.ten}</option>
                <c:forEach items="${sanPhams}" var="sanPhams">
                    <option value="${sanPhams.id}">${sanPhams.ten}</option>
                </c:forEach>
            </select>

            <label>ID Nhà sản xuất</label>
            <select class="form-select" aria-label="Default select example" name="idNsx">
                <option value="${ctsp.nsx.id}">${ctsp.nsx.ten}</option>
                <c:forEach items="${nsxs}" var="nsxs">
                    <option value="${nsxs.id}">${nsxs.ten}</option>
                </c:forEach>
            </select>

            <label>ID Màu sắc</label>
            <select class="form-select" aria-label="Default select example" name="idMauSac">
                <option value="${ctsp.mauSac.id}" selected>${ctsp.mauSac.ten}</option>
                <c:forEach items="${mauSacs}" var="ms">
                    <option value="${ms.id}">${ms.ten}</option>
                </c:forEach>
            </select>

            <label>ID Dòng sản phẩm</label>
            <select class="form-select" aria-label="Default select example" name="idDongSP">
                <option value="${ctsp.dongSP.id}">${ctsp.dongSP.ten}</option>
                <c:forEach items="${dongSPs}" var="dongSPs">
                    <option value="${dongSPs.id}">${dongSPs.ten}</option>
                </c:forEach>
            </select>

            <label>Năm bảo hành</label>
            <input class="form-control" type="number" aria-label="default input example" name="namBH"
                   value="${ctsp.namBH}">

            <label>Mô tả</label>
            <input class="form-control" type="text" aria-label="default input example" name="moTa" value="${ctsp.moTa}">

            <label>Số lượng tồn</label>
            <input class="form-control" type="number" aria-label="default input example" name="soLuongTon"
                   value="${ctsp.soLuongTon}">

            <label>Giá nhập</label>
            <input class="form-control" type="number" aria-label="default input example" name="giaNhap"
                   value="${ctsp.giaNhap}">

            <label>Giá bán</label>
            <input class="form-control" type="number" aria-label="default input example" name="giaBan"
                   value="${ctsp.giaBan}">

            <button type="submit" class="btn btn-success">Update</button>
        </form>
    </div>
</section>

<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
</html>
