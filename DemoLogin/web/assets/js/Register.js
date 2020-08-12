$(function(){
    var userObj;
    var reg_name = document.getElementById("regname");
    var reg_name = regname.value;
    if(reg_name==""){
        alert("用户名不能为空");
    }else{
        $.post(
            "user/Reg-Log?param=yanzheng",
            {"name":reg_name},
            function (reqData) {//传输过来的只有errCode
                console.log(reqData);
                userObj=JSON.parse(reqData);//依旧是字符串转成对象
                if (userObj==0){
                    alert("用户名可用");
                    reg_name=document.getElementById("btnSure");
                    reg_name.disabled=false;
                }else{
                    alert("该用户名已存在！！！");
                    $("#logname").val("");
                    reg_name=document.getElementById("btnSure");
                    reg_name.disabled=true;
                }
            }
        )
    }


    $("#btnSure").click(function () {
            var pass = document.getElementById("regpass")
            var patt = /^[0-9a-zA-Z_]{6,12}$/;
            alert("执行校验")
            if (!patt.test(pass.value)) {
                alert("密码要求（6--12，数字和字母相结合）");
            }else{
                $.post(
                    "user/Reg-Log?param=register",
                    $("#formReg").serialize(),
                    function (reqData) {
                        var obj = JSON.parse(reqData);
                        alert(obj.msg);
                        if (obj.errCode == 0) {
                            alert(reqData);
                            var userObj = obj.data;
                            localStorage.setItem("loguser", JSON.stringify(userObj));
                            location.href = "Login.html";
                        }
                    }
                );
            }
    });
})