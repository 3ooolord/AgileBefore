//注册
var newname=function () {
    if (document.getElementById("newname1").value.length<6||length>15){
        $("#resmsg1").html("账号长度不正确".fontcolor("orangered"));
    }else {
        $("#resmsg1").html("可以使用".fontcolor("green"));
    }
};

var newpassword1=function () {
    if (document.getElementById("newpw").value.length<6||length>15){
        $("#resmsg2").html("密码长度不正确".fontcolor("orangered"));
    }else {
        $("#resmsg2").html("可以使用".fontcolor("green"));
    }
};

var newpassword2=function () {
    if ($("#newpw1").val()!=$("#newpw").val()){
        $("#resmsg3").html("两次输入不一致".fontcolor("orangered"));
    }else {
        $("#resmsg3").html("输入一致".fontcolor("green"));
    }
};

var register=function () {
    $.ajax({
        url:"http://localhost:8080/insertUsers",
        type:"get",
        data:$("#registerForm").serialize(),
        dataType:"json",
        success:function (rs) {
            if (rs.ok) {
                alert(rs.respMsg);
                window.location.href = "charts.html";
            }else {
                alert(rs.respMsg);
            }
        },
        error:function (rs) {

        }

    });
};

var getPid=function () {
    $.ajax({
        url: "http://localhost:8080/getPid",
        type: "get",
        data: $("#registerForm").serialize(),
        dataType: "json",
        success:function (rs) {
            if(rs.ok){
                $("#resmsg4").html(rs.respMsg);
            }else {
                $("#resmsg4").html(rs.respMsg);
            }
        },
        error:function (rs) {

        }
    });
};


var updateperson=function () {
    $.ajax({
        url: "http://localhost:8080/updatePerson",
        type: "get",
        data: $("#personInfo").serialize(),
        dataType: "json",
        success:function (rs) {
            if(rs.ok){
                alert("保存成功");
            }else {
                alert("个人编号不能为空");
            }
        },
        error:function (rs) {
            
        }
    });
};

var insertteacher=function () {
    $.ajax({
        url: "http://localhost:8080/insertTeacher",
        type: "get",
        data: $("#teachertbl").serialize(),
        dataType: "json",
        success:function (rs) {
            if(rs.ok){
                alert(rs.respMsg);
            }else {
                alert(rs.respMsg);
            }
        },
    });
};

