<!DOCTYPE html>
<html>
<head>
<#include "inc/meta.ftl"/>
<#include "inc/alert.ftl"/>
<@meta/>
    <link rel="stylesheet" href="/styles/login.css" type="text/css"/>
    <link rel="stylesheet" href="/styles/alert.css" type="text/css"/>
    <script src="/scripts/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="/scripts/public.js" type="text/javascript"></script>
    <script src="/scripts/login.js" type="text/javascript"></script>
</head>
<body>
<div class="login-container">
    <h1>登陆学生公寓管理系统</h1>
    <div>
        <div>
            <input type="text" name="username" class="username" placeholder="用户名"/>
        </div>
        <div>
            <input type="password" name="password" class="password" placeholder="密码"/>
        </div>
        <button id="submit">登 录</button>
        <button id="submiting"style="background-color: #39b3d7;display: none;">登 录 中...</button>
    </div>
    <a href="/register">
        <button type="button" class="register-tis">还有没有账号？</button>
    </a>
</div>
<ul id="supersized" class="quality" style="visibility: visible;">
    <li class="slide-0 activeslide" style="visibility: visible; opacity: 0.3;">
        <a>
            <img src="/images/bg.jpg" style="width: 1349px; height: 849.87px; left: 0px;"/>
        </a>
    </li>
</ul>
<@alert/>
</body>
</html>