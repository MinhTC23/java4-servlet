<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/26/2023
  Time: 3:49 PM
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
        <form action="/chi-tiet-san-pham/add" method="post">
            <label>ID Sản phẩm</label>
            <select class="form-select" aria-label="Default select example" name="idSP">
                <c:forEach items="${sanPhams}" var="sp">
                    <option value="${sp.id}">${sp.ten}</option>
                </c:forEach>
            </select>

            <label>ID Nhà sản xuất</label>
            <select class="form-select" aria-label="Default select example" name="idNsx">
                <c:forEach items="${nsxs}" var="nsx">
                    <option value="${nsx.id}">${nsx.ten}</option>
                </c:forEach>
            </select>

            <label>ID Màu sắc</label>
            <select class="form-select" aria-label="Default select example" name="idMauSac">
                <c:forEach items="${mauSacs}" var="ms">
                    <option value="${ms.id}">${ms.ten}</option>
                </c:forEach>
            </select>

            <label>ID Dòng sản phẩm</label>
            <select class="form-select" aria-label="Default select example" name="idDongSP">
                <c:forEach items="${dongSPs}" var="dongSP">
                    <option value="${dongSP.id}">${dongSP.ten}</option>
                </c:forEach>
            </select>

            <label>Năm bảo hành</label>
            <input class="form-control" type="number" aria-label="default input example" name="namBH">

            <label>Mô tả</label>
            <input class="form-control" type="text" aria-label="default input example" name="moTa">

            <label>Số lượng tồn</label>
            <input class="form-control" type="number" aria-label="default input example" name="soLuongTon">

            <label>Giá nhập</label>
            <input class="form-control" type="number" aria-label="default input example" name="giaNhap">

            <label>Giá bán</label>
            <input class="form-control" type="number" aria-label="default input example" name="giaBan">

            <button type="submit" class="btn btn-success">Add</button>
        </form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Id Sản phẩm</th>
                <th scope="col">Id Nhà sản xuất</th>
                <th scope="col">Id Màu sắc</th>
                <th scope="col">Id Dòng sản phẩm</th>
                <th scope="col">Năm bảo hành</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Số lượng tồn</th>
                <th scope="col">Giá nhập</th>
                <th scope="col">Giá bán</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${chiTietSPs}" var="chiTietSP">
                <tr>
                    <td>${chiTietSP.id}</td>
                    <td>${chiTietSP.sanPham.ten}</td>
                    <td>${chiTietSP.nsx.ten}</td>
                    <td>${chiTietSP.mauSac.ten}</td>
                    <td>${chiTietSP.dongSP.ten}</td>
                    <td>${chiTietSP.namBH}</td>
                    <td>${chiTietSP.moTa}</td>
                    <td>${chiTietSP.soLuongTon}</td>
                    <td>${chiTietSP.giaNhap}</td>
                    <td>${chiTietSP.giaBan}</td>
                    <td>
                        <a href="/chi-tiet-san-pham/detail?id=${chiTietSP.id}" class="btn btn-success" role="button">Detail</a>
                        <a href="/chi-tiet-san-pham/delete?id=${chiTietSP.id}" class="btn btn-success" role="button">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
</html>
