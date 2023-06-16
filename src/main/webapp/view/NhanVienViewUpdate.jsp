<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/26/2023
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nhân viên</title>
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
        <h1>Nhân viên</h1>
        <form action="/nhan-vien/update?id=${nv.id}" method="post">
            <label>ID</label>
            <input class="form-control" type="text" aria-label="default input example" name="id" value="${nv.id}">

            <label>Mã</label>
            <input class="form-control" type="text" aria-label="default input example" name="ma" value="${nv.ma}">

            <label>Tên</label>
            <input class="form-control" type="text" aria-label="default input example" name="ten" value="${nv.ten}">

            <label>Tên đệm</label>
            <input class="form-control" type="text" aria-label="default input example" name="tenDem" value="${nv.tenDem}">

            <label>Họ</label>
            <input class="form-control" type="text" aria-label="default input example" name="ho" value="${nv.ho}">

            <label>Giới tính</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault1" value="Nam" ${nv.gioiTinh == "Nam"?"checked":""}>
                <label class="form-check-label" for="flexRadioDefault1">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault2" value="Nữ" ${nv.gioiTinh == "Nữ"?"checked":""}>
                <label class="form-check-label" for="flexRadioDefault2">
                    Nữ
                </label>
            </div>

            <label>Ngày sinh</label>
            <input class="form-control" type="date" aria-label="default input example" name="ngaySinh" value="${ngaySinh}">

            <label>Địa chỉ</label>
            <input class="form-control" type="text" aria-label="default input example" name="diaChi" value="${nv.diaChi}">

            <label>Số điện thoại</label>
            <input class="form-control" type="text" aria-label="default input example" name="sdt" value="${nv.sdt}">

            <label>Mật khẩu</label>
            <input class="form-control" type="text" aria-label="default input example" name="matKhau" value="${nv.matKhau}">

            <label>ID Cửa hàng</label>
            <select class="form-select" aria-label="Default select example" name="idCH">
                <option value="${nv.cuaHang.id}">${nv.cuaHang.ten}</option>
                <c:forEach items="${cuaHangs}" var="ch">
                    <option value="${ch.id}">${ch.ten}</option>
                </c:forEach>
            </select>

            <label>ID Chức vụ</label>
            <select class="form-select" aria-label="Default select example" name="idCV">
                <option value="${nv.chucVu.id}">${nv.chucVu.ten}</option>
                <c:forEach items="${chucVus}" var="cv">
                    <option value="${cv.id}">${cv.ten}</option>
                </c:forEach>
            </select>

            <label>Trạng thái</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault3" value="0" ${nv.trangThai == "0"?"checked":""}>
                <label class="form-check-label" for="flexRadioDefault3">
                    Online
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault4" value="1" ${nv.trangThai == "1"?"checked":""}>
                <label class="form-check-label" for="flexRadioDefault4">
                    Offline
                </label>
            </div>

            <button type="submit" class="btn btn-success">Update</button>
        </form>
    </div>
</section>

<footer>
    <%@include file="layout/footer.jsp"%>
</footer>
</body>
</html>
