$(function(){
    var tempStr2 = sessionStorage.getItem("sucessuser");
    var userObj;
    if (tempStr2!= null && tempStr2 != ""){
        userObj = JSON.parse(tempStr2);
        $("#reid").val(userObj.id);
        $("#rename").val(userObj.name);
        $("#repass").val(userObj.pass);
        $("#remobile").val(userObj.mobile);
        $("#rebirthday").val(userObj.birthday);
        if(null != userObj.photo &&"" != userObj.photo){
            $("#showPhoto").attr('src', userObj.photo)
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
                reqData = JSON.parse(reqData);
                alert(reqData.msg);
                if (reqData.errCode == 0){
                    $("#showPhoto").attr('src', reqData.data);
                }
            }
        })
    })

    $("#btnremake").click(function () {
        var pass = document.getElementById("repass");
        var patt = /^[0-9a-zA-Z_]{6,12}$/;
        alert("执行校验")
        let info = $("#remake").serialize();
        alert(info)
        if (!patt.test(pass.value)) {
            alert("密码要求（6--12，数字和字母相结合）");
        }else {
            $.post(
                "user/Reg-Log?param=remake",
                $("#remake").serialize(),
                function (reqData) {
                    var obj = JSON.parse(reqData);
                    if (obj.errCode == 0){
                        var userObj = obj.data;
                        sessionStorage.setItem("sucessuser" , JSON.stringify(userObj));
                        location.href = "personal.html";
                    }
                }
            );
            alert("修改成功");
        }
    });
})