$(function () {
    var userStr = sessionStorage.getItem("sucessuser");
    var userObj;
    if (null !=userStr && userStr != ""){
        userObj = JSON.parse(userStr);
        alert(userObj.name);
    }
})