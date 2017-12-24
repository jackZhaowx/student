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
            $(".community,.dormitory_building").addClass("active-menu");
            $(".community-manager").addClass("active");
            $(".shequ").addClass("active");
            $(".community-manager ul").addClass("collapse in");
            $('#submit').on('click', function () {
                var ofComm = $("#ofComm").val();
                var number = $("#number").val();
                var level = $("#level").val();
                var wheel = $("#wheel").val();
                var phone = $("#phone").val();
                var name = $("#name").val();
                if (ofComm.length == 0) {
                    alert("请所属选择社区！");
                    return;
                }
                if (name.length == 0) {
                    alert("请输入宿舍楼名称！");
                    return;
                }
                if (number.length == 0) {
                    alert("请输入宿舍楼人数！");
                    return;
                }
                if (level.length == 0) {
                    alert("请输入宿舍楼层数！");
                    return;
                }
                if (wheel.length == 0) {
                    alert("请输入宿舍楼负责人！");
                    return;
                }
                if (phone.length == 0) {
                    alert("请输入宿舍楼负责人电话！");
                    return;
                }
                $.ajax({
                    type: 'post',
                    url: '/community/dormitory_building_add/submit',
                    data: {ofComm: ofComm, name: name,number: number,level: level,wheel: wheel,phone: phone},
                    success: function (data) {
                        if (data == "OK") {
                            alert("添加成功！");
                            window.location.href = "/community/dormitory_building";
                        }
                    }, error: function () {

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
                <label for="firstname" class="col-sm-2 control-label">所属社区</label>
                <div class="col-sm-10">
                    <select id="ofComm" name="usertype" class="selectpicker show-tick form-control">
                    <#list comms as comm>
                        <option value="${comm.id}==${comm.comName}">${comm.comName}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">宿舍楼名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name"
                           placeholder="请输入宿舍楼名称">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">宿舍楼定员人数</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="number"
                           placeholder="请输入宿舍楼定员人数">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">宿舍楼层数</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="level"
                           placeholder="请输入宿舍楼层数">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">宿舍楼负责人</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="wheel"
                           placeholder="请输入宿舍楼负责人">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">宿舍楼负责人电话</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone"
                           placeholder="请输入宿舍楼负责人电话">
                </div>
            </div>
            <div class="form-group" style="text-align:right;">
                <div class="col-sm-offset-2 col-sm-10">
                    <button id="submit" class="btn btn-primary">确认</button>
                </div>
            </div>
        </
        >
    </div>
</div>
<@footer/>
<@load/>
</body>
