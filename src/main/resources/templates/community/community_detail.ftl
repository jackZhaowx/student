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
    <script src="/scripts/community/community_detail.js" type="text/javascript"></script>
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
    <link href="/styles/load_page.css"rel="stylesheet"/>
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
                <li><a href="javascript:void(0)">社区详情</a></li>
            </ol>
        </div>
        <div style="background: #ececec;float: left;width: 100%;padding-bottom: 15px;" class="item_list">

        </div>
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
                getMore(page, "/community/community_list_more");
            }
        });
    }
</script>