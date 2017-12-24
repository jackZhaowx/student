<#setting number_format="0"/>
<!DOCTYPE html>
<html>
<head>
<#include "../inc/meta.ftl"/>
<#include "../inc/style.ftl"/>
<#include "../inc/header.ftl"/>
<#include "../inc/left.ftl"/>
<#include "../inc/footer.ftl"/>
<#include "../inc/load_page.ftl"/>
<@meta/>
<@style/>
    <script src="/scripts/community/dormitory_building.js" type="text/javascript"></script>
    <script src="/scripts/bootstrap-paginator.js" type="text/javascript"></script>
    <style>
        .pagination li {
            cursor: pointer;
            background: #fff;
            margin-right: 5px;
        }

        .pagination li a {
            text-decoration: none;
        }

        .pagination li a:hover {
            background-color: #ee6e73;
            color: white;
        }
    </style>
    <link href="/styles/load_page.css" rel="stylesheet"/>
</head>
<body>
<div id="wrapper">
<@header/>
<@left/>
    <div id="page-wrapper">
        <div class="header">
            <h1 class="page-header">
                公寓管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="javascript:void(0)">社区管理</a></li>
                <li><a href="javascript:void(0)">社区总览</a></li>
            </ol>
        </div>
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">宿舍楼操作</a>
                </div>
            </div>
            <div style="padding: 15px;">
                <button onclick="javascript:window.location.href='/community/dormitory_building_add'" type="button" class="btn btn-primary">
                    添加宿舍楼
                </button>
            </div>
        </nav>
    <#if result.code=="SUCCESS"&&(result.data?size>0)>
        <table class="table table-striped" style="background: #ececec;float: left;width: 100%;padding-bottom: 15px;">
            <thead>
            <tr>
                <th>社区</th>
                <th>宿舍楼</th>
                <th>宿舍个数</th>
                <th>宿舍层数</th>
                <th>负责人</th>
                <th>联系电话</th>
                <th>信息</th>
            </tr>
            </thead>
            <tbody class="item_list">
                <#list result.data as data>
                <tr>
                    <td>${data.parentName}</td>
                    <td>${data.name}</td>
                    <td>${data.number}</td>
                    <td>${data.level}</td>
                    <td>${data.wheel}</td>
                    <td>${data.phone}</td>
                    <td><a href="/community/dormitory_building_detail/${data.id}">详情</a></td>
                </tr>
                </#list>
            </tbody>
        </table>
    <#else>
        <div style="width: 100%;float:right;text-align: center;color: red;">
            没有宿舍楼信息
        </div>
    </#if>
        <div id="page-more" style="text-align: center;width: 100%;">
        </div>
    </div>
</div>
<@footer/>
<@load/>
</body>
<script>
    if (${last}>
    0
    )
    {
        $('#page-more').bootstrapPaginator({
            bootstrapMajorVersion: 2, //版本
            currentPage: 1, //当前页数
            totalPages: ${last}, //总页数
            itemTexts: function (type, page, current) {
                switch (type) {
                    case "first":
                        return "首页";
                    case "prev":
                        return "上一页";
                    case "next":
                        return "下一页";
                    case "last":
                        return "末页";
                    case "page":
                        return page;
                }
            },
            onPageClicked: function (event, originalEvent, type, page) {
                getMore(page, "/community/dormitory_building_more");
            }
        });
    }
</script>