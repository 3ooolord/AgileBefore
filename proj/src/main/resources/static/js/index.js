var getQuestioninfo=function () {
    $.ajax({
        url: "http://localhost:8080/getQuestioninfo",
        type: "get",
        data: $("#txtQikind").serialize(),
        dataType: "json",
        success:function (rs) {
            $("#questiontbl").bootstrapTable('destroy');
                $("#questiontbl").bootstrapTable({
                    data: rs.data,
                    cache:false,
                    checkboxHeader: true,
                    singleSelect: true, //开启单选
                    columns:[
                        {field: "state", checkbox: true, align: 'center',},
                        {field:'qiid',title:'#'},
                        {field:'qikind',title:'题目类型'},
                        {field:'qicontent',title:'试题内容'},
                        {field:'qimark',title:'试题分数'},
                        {field:'qianswer',title:'试题答案'},
                        {field:'qiisrelease',title:'是否发布'},
                    ]
                });
        },
        error:function (rs) {
            alert("抱歉，没有查到数据")
        }
    });
};

//删除数据
$("#deleteqi").click(function() {
    var qiid = getSelect();
    console.info(qiid);
    if(qiid != null) {
        DelDate(qiid);
    }

});

function DelDate(qiid) {
    console.log(qiid);
    $.ajax({
        type: "get",
        dataType: "json",
        data:qiid,
        url: "http://localhost:8080/deleteQuestioninfo",
        success: function(result) {
            var str = [],
                i;
            //下面使用each进行遍历
            $.each(result, function(n, value) {
                //alert(n + ' ' + value);
                if(value["qiid"] != qiid) {
                    console.log(str);
                    str.push(value);
                }
            });
            console.log(str.length);
            if(str.length > 0) {
                createTable(str);
            } else {
                createTable(result);
            }
        }
    });
}

//获取列表选中行
function getSelect() {
    var a = $("#txtQikind").bootstrapTable('getSelections');
    console.info(a);
    if(a.length > 0) {
        return a[0].qiid;
    } else {
        bootbox.alert("必须要选择一条信息！");
    }
}

var insertqi=function () {
    $.ajax({
        url: "http://localhost:8080/insertQuestioninfo",
        type: "get",
        data: $("#questionInfoForm").serialize(),
        dataType: "json",
        success:function (rs) {
            if(rs.ok){
                alert("添加成功")
            }else {
                alert("内容重复或为空，请检查")
            }
        },
    });
};
