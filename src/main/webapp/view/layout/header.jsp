<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/21/2023
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
        crossorigin="anonymous"
/>
<link rel="stylesheet" href="../../css/home.css">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <a href="/trang-chu/hien-thi" role="img"><img src="../../assets/logo.png" alt="" /></a>
<%--                <img src="../../assets/logo.png" alt="" />--%>
            </div>
            <div class="col-lg-6">
                <form class="d-flex" role="search">
                    <input
                            class="form-control me-2"
                            type="search"
                            placeholder="Search"
                            aria-label="Search"
                    />
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
            <div class="col-lg-3">
                <a href="/Login" class="aheader" id="koko">Đăng nhập</a>
                <a
                        href=""
                        class="aheader"
                        id="kko"
                        style="display: none"
                >Đăng xuất</a
                >
                <a href="/trang-chu/hien-thi" class="aheader">Trang của tôi</a>
                <button
                        type="button"
                        class="btn btn-primary position-relative"
                        id="heart"
                >
                    <a href="/trang-chu/cart"
                    ><img
                            src="../../assets/353439-basket-buy-cart-ecommerce-online-purse-shop-shopping_107515.png"
                            alt=""
                    /></a>
                    <span
                            class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"
                            id="icon_header"
                    >
          2
          <span class="visually-hidden">unread messages</span>
        </span>
                </button>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <nav class="navbar navbar-expand-lg">
                    <div class="container-fluid">
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="/trang-chu/hien-thi"
                                    >Trang chủ</a
                                    >
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="/chi-tiet-san-pham/hien-thi"
                                    >Chi tiết sản phẩm</a
                                    >
                                </li>
<%--                                <li class="nav-item">--%>
<%--                                    <a class="nav-link active" aria-current="page" href="#gioithieu"--%>
<%--                                    >Giới thiệu cửa hàng</a--%>
<%--                                    >--%>
<%--                                </li>--%>
                                <div class="dropdown">
                                    <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        Quản lý
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="/san-pham/hien-thi">Sản phẩm</a></li>
                                        <li><a class="dropdown-item" href="/mau-sac/hien-thi">Màu sắc</a></li>
                                        <li><a class="dropdown-item" href="/nha-san-xuat/hien-thi">Nhà sản xuất</a></li>
                                        <li><a class="dropdown-item" href="/dong-san-pham/hien-thi">Dòng sản phẩm</a></li>
                                        <li><a class="dropdown-item" href="/chuc-vu/hien-thi">Chức vụ</a></li>
                                        <li><a class="dropdown-item" href="/cua-hang/hien-thi">Cửa hàng</a></li>
                                        <li><a class="dropdown-item" href="/khach-hang/hien-thi">Khách hàng</a></li>
                                        <li><a class="dropdown-item" href="/nhan-vien/hien-thi">Nhân viên</a></li>
                                    </ul>
                                </div>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
