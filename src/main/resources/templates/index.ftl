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
</head>
<body>
<div id="wrapper">
<@header/>
<@left/>
    <div id="page-wrapper">
        <div class="header">
            <h1 class="page-header">
                Dashboard
            </h1>
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li><a href="#">Dashboard</a></li>
                <li class="active">Data</li>
            </ol>

        </div>
    </div>
</div>
<@footer/>
</body>