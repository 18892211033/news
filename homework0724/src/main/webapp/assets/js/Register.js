$(function(){
    var str = sessionStorage.getItem("reguser");
    if (null != str && "" != str){
        var userObj = JSON.parse(str);
        $("#name").val(userObj.name);
        $("#password").val("");
    }
    $("#btnlogin").click(function () {
        $.get(
            'users',
            $("#formRegister").serialize(),
            function(reqData) {
                console.log(reqData);
                alert(reqData.msg) ;
                if (reqData.errCode == 0){
                    var sucessData = JSON.stringify(reqData.data);
                    sessionStorage.setItem("sucess",JSON.stringify(reqData.data));
                    location.href="Personal.html";
                }
            }
        );
    })
    $("#btnregister").click(function () {
            var pass = document.getElementById("password")
            var patt = /^[0-9a-zA-Z_]{6,12}$/;
            alert("执行校验")
            if (!patt.test(pass.value)) {
                alert("密码要求（6--12，数字和字母相结合）");
            }else{
                $.post(
                   'users',
                    $("#formRegister").serialize(),
                    function (reqData) {
                        console.log(reqData);
                        if (reqData.errCode == 0){
                            alert(reqData.msg);
                            sessionStorage.setItem("reguser" , JSON.stringify(reqData.data));
                            location.href="Register.html";
                        }
                        if (reqData.errCode != 0){
                            alert(reqData.msg);
                            location.href="Register.html";
                        }
                    }
                );
            }
    });
})