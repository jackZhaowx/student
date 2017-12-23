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
    <script src="/scripts/part/part_list.js" type="text/javascript"></script>
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
            </ol>
        </div>
        <div style="background: #ececec;float: left;width: 100%;padding-bottom: 15px;" class="item_list">
        <#if result.code=="SUCCESS"&&(result.data?size>0)>
            <#list result.data as data>
                <div style="cursor:pointer;background: #fff;width: 18%;border-top-left-radius:20px;border-top-right-radius:20px;float: left;margin-left: 1%;margin-right: 1%;margin-bottom: 10px;">
                    <span style="background: #0D47A1;width:100%;border-top-left-radius:20px;border-top-right-radius:20px;height: 30px;display: block;"></span>
                    <div style="width: 100%;height: 150px;background: url(/images/house${data_index}.png);background-size:100% 150px;"></div>
                    <div style="height: 40px;">
                        <p style="text-align: center;color: orange;padding: 10px 0">${data.paretName}</p>
                    </div>
                </div>
            </#list>
        </#if>
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
                getMore(page, "/part/part_list_more");
            }
        });
    }
</script>