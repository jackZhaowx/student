<!DOCTYPE html>
<html>
<head>
<#include "inc/meta.ftl"/>
<#include "inc/style.ftl"/>
<#include "inc/header.ftl"/>
<#include "inc/left.ftl"/>
<#include "inc/footer.ftl"/>
<@meta/>
<@style/>
    <style>
        .result-icon {
            width: 25px;
            height: 25px;
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
            display: inherit;
            margin-top: -25px;
            margin-left: 43px;
        }

        .result-fail {
            background-image: url(/images/ip.png);
        }

        .ip-span{
            margin-top: -25px;
        }
    </style>
</head>
<body>
<div id="wrapper">
<@header/>
<@left/>
    <div id="page-wrapper">
        <div class="header">
            <h1 class="page-header">
                公寓管理系统
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)">首页</a></li>
                <li><a href="javascript:void(0)">登陆基本信息</a></li>
            </ol>
        </div>
        <div style="padding: 15px;text-align: center;">
            <span style="font-size: 16px;">登陆ip：<span class="ip-span">${ip}</span></span>|
            <span style="font-size: 16px;">登陆时间：<span>${time}</span></span>
        </div>
    </div>
</div>
<@footer/>
</body>