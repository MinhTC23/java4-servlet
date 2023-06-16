<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/24/2023
  Time: 11:00 PM
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
    <%@include file="layout/header.jsp" %>
</header>

<section>
    <div class="container">
        <h1>Khách hàng</h1>
        <form action="/khach-hang/update?id=${kh.id}" method="post">
            <label>Mã</label>
            <input class="form-control" type="text" aria-label="default input example" name="ma" value="${kh.ma}">

            <label>Tên</label>
            <input class="form-control" type="text" aria-label="default input example" name="ten" value="${kh.ten}">

            <label>Tên đệm</label>
            <input class="form-control" type="text" aria-label="default input example" name="tenDem"
                   value="${kh.tenDem}">

            <label>Họ</label>
            <input class="form-control" type="text" aria-label="default input example" name="ho" value="${kh.ho}">

            <label>Ngày sinh</label>
            <input class="form-control" type="date" aria-label="default input example" name="ngaySinh"
                   value="${ngaySinh}">

            <label>Số điện thoại</label>
            <input class="form-control" type="text" aria-label="default input example" name="sdt" value="${kh.sdt}">

            <label>Địa chỉ</label>
            <input class="form-control" type="text" aria-label="default input example" name="diaChi"
                   value="${kh.diaChi}">

            <label>Thành phố</label>
            <input class="form-control" type="text" aria-label="default input example" name="thanhPho"
                   value="${kh.thanhPho}">

            <label>Quốc gia</label>
            <input class="form-control" type="text" aria-label="default input example" name="quocGia"
                   value="${kh.quocGia}">

            <label>Mật khẩu</label>
            <input class="form-control" type="text" aria-label="default input example" name="matKhau"
                   value="${kh.matKhau}">

            <button type="submit" class="btn btn-success">Update</button>
        </form>
    </div>
</section>

<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
</html>
