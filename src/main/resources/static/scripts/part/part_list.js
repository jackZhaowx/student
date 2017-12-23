$(function () {
    $(".part,.part_list").addClass("active-menu");
    $(".apartment").addClass("active");
    $(".shequ").addClass("active");
    $(".apartment ul").addClass("collapse in");
    var hei=$(window).height()-30;
    $("#page-wrapper").css("minHeight",hei+"px");
});

function getMore(num, url) {
    $("#loading").css("display","block");
    var Int=setInterval(function () {
        $.ajax({
            type: 'post',
            url: url,
            data: {num: num},
            success: function (result) {
                if (result.code == "SUCCESS") {
                    $(".item_list").html(getHtml(result.data));
                    $("#loading").css("display","none");
                }
            }, error: function () {

            }
        });
      clearInterval(Int);
    },2000);
}

function getHtml(data) {
    var c = "";
    for (var i = 0; i < data.length; i++) {
        var part = data[i];
        c += '<div style="cursor:pointer;background: #fff;width: 18%;border-top-left-radius:20px;border-top-right-radius:20px;float: left;margin-left: 1%;margin-right: 1%;margin-bottom: 10px;"><span style="background: #0D47A1;width:100%;border-top-left-radius:20px;border-top-right-radius:20px;height: 30px;display: block;"></span>';
        c += '<div style="width: 100%;height: 150px;background: url(/images/house' + i + '.png);background-size:100% 150px;"></div>';
        c += ' <div style="height: 40px;"><p style="text-align: center;color: orange;padding: 10px 0">' + part.paretName + '</p></div></div>';
    }
    return c;
}