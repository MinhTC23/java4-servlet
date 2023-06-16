<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/20/2023
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quên mật khẩu</title>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="css/login.css"/>
</head>
<body>
<div class="card-front">
    <div class="center-wrap">
        <div class="section text-center">
            <h4 class="mb-4 pb-3">Log In</h4>
            <div class="form-group">
                <input type="email" name="logemail" class="form-style" placeholder="Your Email" id="logemail" autocomplete="off">
                <i class="input-icon uil uil-at"></i>
            </div>
            <a href="/Login" class="btn mt-4">submit</a>
        </div>
    </div>
</div>
</body>
</html>
