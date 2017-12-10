/**
 * Created by Administrator on 2017/12/10.
 */
function isUsername(username) {
    var reg=/^[a-zA-Z0-9_-]{4,16}$/;
    return reg.test(username);
}
function isPassword(password) {
    var reg=/^.*(?=.{6,})(?=.*\d)(?=.*[A-Za-z]).*$/;
    return reg.test(password);
}
function isMobile(phone) {
    var reg=/^1[34578]\d{9}$/;
    return reg.test(phone);
}
function isEmpty(value) {
    if (value == undefined || value == null || value == "") {
        return true;
    }
    return false;
}
function isEmail(email) {
    var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    return reg.test(email);
}
function alertShow() {
    $("#alert_bg").show();
    $("#alert_content").show();
}
function alertClose() {
    $("#alert_bg").hide();
    $("#alert_content").hide();
}
