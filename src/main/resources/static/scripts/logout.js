/**
 * Created by Administrator on 2017/12/10.
 */
function logout() {
    $.ajax({
        type:"get",
        url:"/logout",
        success:function (data) {
            window.location.href="/login";
        },error:function (data) {

        }
    })
}
