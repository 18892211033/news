$(function () {
    var typeId = localStorage.getItem("typeId");
    $.get(
        'newstype' + typeId,
        function (reqData) {
            console.log(reqData);
            typeObj = JSON.parse(reqData);
            if (0 == typeObj.errCode){
                newsArr = typeObj.data;
                var str ="";
                $.each(newsArr,function(index , item) {
                    str +="<li onclick='toList("+item.id+")'>";
                    str += item.typename ;
                    str +="</li>";
                });
                $("#showtype").html(str);
            }
        }
    );
})
function toList(typeId) {
    localStorage.setItem("typeId" , typeId);
    window.open('newsList.html',"_blank");
}