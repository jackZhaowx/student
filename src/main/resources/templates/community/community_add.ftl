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
    <script>
        $(function () {
            $(".community,.community_list").addClass("active-menu");
            $(".community-manager").addClass("active");
            $(".shequ").addClass("active");
            $(".community-manager ul").addClass("collapse in");
            $('#submit').on('click',function () {
               var communame=$("#communame").val();
               var demo=$("#demo").val();
               if(communame.length==0){
                   alert("请输入社区名称！");
                   return;
               }
               $.ajax({
                   type:'post',
                   url:'/community/community_add/submit',
                   data:{communame:communame,demo:demo},
                   success:function (data) {
                       if(data=="OK"){
                           alert("添加成功！");
                           window.location.href="/community";
                       }
                   },error:function () {

                   }
               })
            });
        });
    </script>
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
                <li><a href="javascript:void(0)">添加社区</a></li>
            </ol>
        </div>
        <div class="form-horizontal" style="background: #fff;padding: 20px">
            <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">社区名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="communame"
                           placeholder="请输入社区名称">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">社区备注</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="demo"
                           placeholder="请输入社区备注">
                </div>
            </div>
            <div class="form-group" style="text-align:right;">
                <div class="col-sm-offset-2 col-sm-10">
                    <button id="submit" class="btn btn-primary">确认</button>
                </div>
            </div>
        </>
    </div>
</div>
<@footer/>
<@load/>
</body>
