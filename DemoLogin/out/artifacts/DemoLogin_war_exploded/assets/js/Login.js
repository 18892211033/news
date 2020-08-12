$(function () {
    var userObj;
    var tempStr = localStorage.getItem("loguser");

    if (tempStr != null && tempStr != ""){
        userObj = JSON.parse(tempStr);
        $("#logname").val(userObj.name);
        $("#logmobile").val(userObj.mobile);
        $("#logbirthday").val(userObj.birthday);
        $("#logpass").val("");
    }
    $("#btnSure").click(function () {
        $.post(
            "user/Reg-Log?param=login",
            $("#formLogin").serialize(),
            function(reqData) {
                console.log(reqData);
                var obj = JSON.parse(reqData);
                if (obj.errCode == 0){

                    sessionStorage.setItem("sucessuser" , JSON.stringify(obj.data));
                    alert("登陆成功返回sucess.html")
                    location.href = "sucess.html";
                }else {
                    alert("用户名或密码不正确");
                    $("#logname").focus();
                    $("#logname").select();
                }
            }
        );
    });
})