$(function(){
    var str = sessionStorage.getItem("sucess");
    var userObj = JSON.parse(str);
    if (userObj!= null && userObj != ""){
        $("#id").val(userObj.id);
        $("#name").val(userObj.name);
        $("#password").val(userObj.password);
        $("#regDatetime").val(userObj.regDatetime);
        if(null != userObj.photoUrl &&"" != userObj.photoUrl){
            $("#showPhoto").attr('src', userObj.photoUrl)
        }
    }

    $("#btnUp").click(function () {
        var formData = new FormData($("#Up")[0]);
        $.ajax({
            type : 'post',
            url : 'file/upload',
            data : formData,
            contentType : false,
            processData : false,
            success : function (reqData) {
                console.log(reqData);
                alert(reqData.msg);
                if (reqData.errCode == 0){
                    $("#showPhoto").attr('src', reqData.data);
                }
            }
        })
    })

    $("#btnremake").click(function () {
        var pass = document.getElementById("password");
        var patt = /^[0-9a-zA-Z_]{6,12}$/;
        alert("执行校验")
        // alert(info)
        if (!patt.test(pass.value)) {
            alert("密码要求（6--12，数字和字母相结合）");
        }else {
            $.ajax({
                type : 'PUT',
                url : 'users',
                data : JSON.stringify({id : $("#id").val() , password : $("#password").val() , name : $("#name").val() ,
                         regDatetime : $("#regDatetime").val() , /*status : $("#status").val() ,*/ photoUrl : $("#photoUrl").val()}) ,
                contentType : 'application/json;charset=UTF-8' ,
                dataType : 'json' ,
                success : function (reqData) {
                    if (reqData.errCode == 0){
                        alert(reqData.msg);
                        sessionStorage.setItem("sucess" , JSON.stringify(reqData.data));
                        location.href = "Personal.html";
                    }
                }
            });
        }
    });
})