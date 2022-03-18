
var login=function () {
    if ($("[name='paccount']").val().length==0){
        $("#msg").html("用户名不能为空");
        return;
    }
    if ($("[name='ppassword']").val().length==0){
        $("#msg").html("密码不能为空");
        return;
    }
    $.ajax({
        url:"http://localhost:8080/getLogin",
        type:"post",
        data:$("#lgnForm").serialize(),
        dataType:"json",
        success:function (rs) {
            if (rs.ok) {
                window.location.href = "index.html";
            }else {
                $("#msg").html(rs.respMsg);
            }
        },
        error:function (rs) {

        }

    });
};
