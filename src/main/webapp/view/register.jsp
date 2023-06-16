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
    <title>Đăng kí</title>
    <link rel="stylesheet" href="../css/login.css"/>
    <script src="../js/login.js"></script>
</head>
<body>
<section class="container">
    <div class="login-container">
        <div class="circle circle-one"></div>
        <div class="form-container">
            <img src="https://raw.githubusercontent.com/hicodersofficial/glassmorphism-login-form/master/assets/illustration.png" alt="illustration" class="illustration" />
            <h1 class="opacity">REGISTER</h1>
            <form>
                <input type="text" placeholder="USERNAME" />
                <input type="password" placeholder="PASSWORD" />
                <input type="email" placeholder="EMAIL" />
                <input type="text" placeholder="NUMBERS" />
                <button class="opacity">SUBMIT</button>
            </form>
            <div class="register-forget opacity" style="padding-left: 120px">
                <a href="/Login">LOGIN</a>
            </div>
        </div>
        <div class="circle circle-two"></div>
    </div>
    <div class="theme-btn-container"></div>
</section>
</body>
</html>
