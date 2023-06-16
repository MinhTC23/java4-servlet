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
        <form action="/nhan-vien/add" method="post">
            <label>Mã</label>
            <input class="form-control" type="text" aria-label="default input example" name="ma">

            <label>Tên</label>
            <input class="form-control" type="text" aria-label="default input example" name="ten">

            <label>Tên đệm</label>
            <input class="form-control" type="text" aria-label="default input example" name="tenDem">

            <label>Họ</label>
            <input class="form-control" type="text" aria-label="default input example" name="ho">

            <label>Giới tính</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault1" value="Nam" checked>
                <label class="form-check-label" for="flexRadioDefault1">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault2" value="Nữ">
                <label class="form-check-label" for="flexRadioDefault2">
                    Nữ
                </label>
            </div>

            <label>Ngày sinh</label>
            <input class="form-control" type="date" aria-label="default input example" name="ngaySinh">

            <label>Địa chỉ</label>
            <input class="form-control" type="text" aria-label="default input example" name="diaChi">

            <label>Số điện thoại</label>
            <input class="form-control" type="text" aria-label="default input example" name="sdt">

            <label>Mật khẩu</label>
            <input class="form-control" type="text" aria-label="default input example" name="matKhau">

            <label>ID Cửa hàng</label>
            <select class="form-select" aria-label="Default select example" name="idCH">
                <c:forEach items="${cuaHangs}" var="ch">
                    <option value="${ch.id}">${ch.ten}</option>
                </c:forEach>
            </select>

            <label>ID Chức vụ</label>
            <select class="form-select" aria-label="Default select example" name="idCV">
                <c:forEach items="${chucVus}" var="cv">
                    <option value="${cv.id}">${cv.ten}</option>
                </c:forEach>
            </select>

<%--            <label>ID GuiBC</label>--%>
<%--            <input class="form-control" type="number" aria-label="default input example" name="idGuiBC">--%>

            <label>Trạng thái</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault3" value="0" checked>
                <label class="form-check-label" for="flexRadioDefault3">
                    Online
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault4" value="1">
                <label class="form-check-label" for="flexRadioDefault4">
                    Offline
                </label>
            </div>

            <button type="submit" class="btn btn-success">Add</button>
        </form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Mã</th>
                <th scope="col">Họ và tên</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Mật khẩu</th>
                <th scope="col">ID Cửa hàng</th>
                <th scope="col">ID Chức vụ</th>
<%--                <th scope="col">ID GuiBC</th>--%>
                <th scope="col">Trạng thái</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="nv">
                <tr>
                    <td>${nv.id}</td>
                    <td>${nv.ma}</td>
                    <td>${nv.ho} ${nv.tenDem} ${nv.ten}</td>
                    <td>${nv.gioiTinh}</td>
                    <td>${nv.ngaySinh}</td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.sdt}</td>
                    <td>${nv.matKhau}</td>
                    <td>${nv.cuaHang.ten}</td>
                    <td>${nv.chucVu.ten}</td>
<%--                    <td>${nv.idGuiBC}</td>--%>
                    <td>
                        <c:if test="${nv.trangThai == 0}">Online</c:if>
                        <c:if test="${nv.trangThai == 1}">Offline</c:if>
                    </td>
                    <td>
                        <a href="/nhan-vien/detail?id=${nv.id}" class="btn btn-success" role="button">Detail</a>
                        <a href="/nhan-vien/delete?id=${nv.id}" class="btn btn-success" role="button">Delete</a>
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
