<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/24/2023
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Khách hàng</title>
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
        <h1>Khách hàng</h1>
        <form action="/khach-hang/add" method="post">
            <label>Mã</label>
            <input class="form-control" type="text" aria-label="default input example" name="ma">

            <label>Tên</label>
            <input class="form-control" type="text" aria-label="default input example" name="ten">

            <label>Tên đệm</label>
            <input class="form-control" type="text" aria-label="default input example" name="tenDem">

            <label>Họ</label>
            <input class="form-control" type="text" aria-label="default input example" name="ho">

            <label>Ngày sinh</label>
            <input class="form-control" type="date" aria-label="default input example" name="ngaySinh">

            <label>Số điện thoại</label>
            <input class="form-control" type="text" aria-label="default input example" name="sdt">

            <label>Địa chỉ</label>
            <input class="form-control" type="text" aria-label="default input example" name="diaChi">

            <label>Thành phố</label>
            <input class="form-control" type="text" aria-label="default input example" name="thanhPho">

            <label>Quốc gia</label>
            <input class="form-control" type="text" aria-label="default input example" name="quocGia">

            <label>Mật khẩu</label>
            <input class="form-control" type="text" aria-label="default input example" name="matKhau">

            <button type="submit" class="btn btn-success">Add</button>
        </form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Mã</th>
                <th scope="col">Họ và tên</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Thành phố</th>
                <th scope="col">Quốc gia</th>
                <th scope="col">Mật khẩu</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="kh">
                <tr>
                    <td>${kh.id}</td>
                    <td>${kh.ma}</td>
                    <td>${kh.ho} ${kh.tenDem} ${kh.ten}</td>
                    <td>${kh.ngaySinh}</td>
                    <td>${kh.sdt}</td>
                    <td>${kh.diaChi}</td>
                    <td>${kh.thanhPho}</td>
                    <td>${kh.quocGia}</td>
                    <td>${kh.matKhau}</td>
                    <td>
                        <a href="/khach-hang/detail?id=${kh.id}" class="btn btn-success" role="button">Detail</a>
                        <a href="/khach-hang/delete?id=${kh.id}" class="btn btn-success" role="button">Delete</a>
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
