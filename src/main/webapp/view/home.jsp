<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div id="carouselExample" class="carousel slide">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img
                                src="../../assets/banner-1.jpg"
                                class="d-block w-100"
                                alt="..."
                        />
                    </div>
                    <div class="carousel-item">
                        <img
                                src="../../assets/banner-2.jpg"
                                class="d-block w-100"
                                alt="..."
                        />
                    </div>
                </div>
                <button
                        class="carousel-control-prev"
                        type="button"
                        data-bs-target="#carouselExample"
                        data-bs-slide="prev"
                >
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button
                        class="carousel-control-next"
                        type="button"
                        data-bs-target="#carouselExample"
                        data-bs-slide="next"
                >
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div>
                <h3 class="title">Sản phẩm bán chạy nhất</h3>
            </div>
        </div>
    </div>

    <div class="row">
        <c:forEach items="${chiTietSPs}" var="chiTietSP">
            <div
                    class="col-xl-3 col-lg-4 col-md-6"
                    id="cardd"
            >
                <div class="card" style="width: 262.5px; border: white">
                    <a href="/chi-tiet-san-pham/detail?id=${chiTietSP.id}"
                    ><img src="/assets/feature-1.jpg" class="card-img-top" alt="..."
                    /></a>
                    <div class="card-body">
                        <p class="card-text">
                            ${chiTietSP.sanPham.ten} <br/>
                            <b>$${chiTietSP.giaBan}</b>
                        </p>
                        <a href="#"
                        >
                            <button type="button" class="btn btn-outline-success">
                                Buy now
                            </button>
                        </a
                        >
                        <a href="/trang-chu/add?id=${chiTietSP.id}">
                            <button
                                    type="button"
                                    class="btn btn-outline-success"
                                    style="float: right"
                            >
                                Add to cart
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div>
                <h3 class="title">Sản phẩm mới nhất</h3>
            </div>
        </div>
    </div>

    <div class="row">
        <c:forEach items="${chiTietSPs}" var="chiTietSP">
            <div
                    class="col-xl-3 col-lg-4 col-md-6"
                    id="cardd"
            >
                <div class="card" style="width: 262.5px; border: white">
                    <a href="/chi-tiet-san-pham/detail?id=${chiTietSP.id}"
                    ><img src="/assets/feature-1.jpg" class="card-img-top" alt="..."
                    /></a>
                    <div class="card-body">
                        <p class="card-text">
                                ${chiTietSP.sanPham.ten} <br/>
                            <b>$${chiTietSP.giaBan}</b>
                        </p>
                        <a href="#"
                        >
                            <button type="button" class="btn btn-outline-success">
                                Buy now
                            </button>
                        </a
                        >
                        <a href="/trang-chu/add?id=${chiTietSP.id}">
                            <button
                                    type="button"
                                    class="btn btn-outline-success"
                                    style="float: right"
                            >
                                Add to cart
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
