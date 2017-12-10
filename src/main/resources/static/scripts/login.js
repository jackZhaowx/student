/**
 * Created by Administrator on 2017/12/10.
 */
$(function () {
    $("#alert_close").on("click", function () {
        alertClose();
    });
    $("#submit").on("click", function () {
        var username = $(".username").val();
        var password = $(".password").val();
        if(isEmpty(username)){
            $(".zbox-popup-text").html("用户名不能为空！");
            alertShow();
            return;
        }
        if (isEmpty(password)) {
            $(".zbox-popup-text").html("密码不能为空！");
            alertShow();
            return;
        }
        $("#submit").hide();
        $("#submiting").show();
        var formBean=new Object();
        formBean.username=username;
        formBean.password=password;
        $.ajax({
            type:"post",
            url:"/login/dolocation",
            data:JSON.stringify(formBean),
            contentType: "application/json",
            success:function (data) {
                if(data=="OK"){
                    window.location.href="/";
                    $(".zbox-popup-text").html("登陆成功，即将跳至首页...");
                    $("#alert_close").remove();
                    alertShow();
                }else if(data=="NO"){
                    $(".zbox-popup-text").html("用户名或密码错误！");
                    alertShow();
                    $("#submiting").hide();
                    $("#submit").show();
                }
            },error:function (data) {

            }
        })
    });
});
