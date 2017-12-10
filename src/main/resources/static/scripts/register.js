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
        var confirm_password = $(".confirm_password").val();
        var user_nickname = $(".user_nickname").val();
        if (isEmpty(username)) {
            $(".zbox-popup-text").html("用户名不能为空！");
            alertShow();
            return;
        }
        if (!isUsername(username)) {
            $(".zbox-popup-text").html("请输入正确的用户名！");
            alertShow();
            return;
        }
        if (isEmpty(password)) {
            $(".zbox-popup-text").html("密码不能为空！");
            alertShow();
            return;
        }
        if (isEmpty(confirm_password)) {
            $(".zbox-popup-text").html("确认密码不能为空！");
            alertShow();
            return;
        }
        if (!(password.trim() == confirm_password.trim())) {
            $(".zbox-popup-text").html("俩次密码不一致！");
            alertShow();
            return;
        }
        if (!isPassword(password)) {
            $(".zbox-popup-text").html("请输入正确的密码组合！");
            alertShow();
            return;
        }
        if (isEmpty(user_nickname)) {
            $(".zbox-popup-text").html("用户昵称不能为空！");
            alertShow();
            return;
        }
        var formBean = new Object();
        formBean.username = username;
        formBean.password = password;
        formBean.nickname = user_nickname;
        $.ajax({
            type: "post",
            url: "/register/doaction",
            data: JSON.stringify(formBean),
            contentType: "application/json",
            success: function (data) {
                if (data == "NOTNULL") {
                    $(".zbox-popup-text").html("用户名已经存在！");
                    alertShow();
                } else if (data == "OK") {
                    window.location.href = "/login";
                }
            }, error: function (data) {

            }
        })
    });
});
