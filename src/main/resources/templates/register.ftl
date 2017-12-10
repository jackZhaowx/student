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
    <script src="/scripts/register.js" type="text/javascript"></script>
</head>
<body>
<div class="register-container">
    <h1>注册公寓管理系统账户</h1>
    <div>
        <div>
            <input type="text" name="username" class="username" placeholder="用户名有字母和密码组成，最大长度20" maxlength="20"/>
        </div>
        <div>
            <input type="password" name="password" class="password" placeholder="密码(至少由一个数字和字母组成长度大于6)" />
        </div>
        <div>
            <input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码"/>
        </div>
        <div>
            <input type="text" name="user_nickname" class="user_nickname" placeholder="用户昵称"/>
        </div>
        <button id="submit" type="button">注 册</button>
    </div>
    <a href="/login">
        <button type="button" class="register-tis">已经有账号？</button>
    </a>
</div>
<ul id="supersized" class="quality" style="visibility: visible;">
    <li class="slide-0 activeslide" style="visibility: visible; opacity: 0.3;">
        <a target="_blank">
            <img src="/images/bg.jpg" style="width: 1349px; height: 849.87px; left: 0px;"/>
        </a>
    </li>
</ul>
<@alert/>
</body>
</html>