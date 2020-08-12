$(function () {
    $.get(
        'newstype',
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
    //请求最新前5条新闻
    $.get(
        'news?param=top',
        function(reqData) {
            // console.log(reqData);
            newsObj = JSON.parse(reqData);
            newsArr = newsObj.data;
            if (0 == newsObj.errCode) {
                var str = "";
                $.each(newsArr , function (index , item) {
                    str +="<li>";
                    str +="<h3 onclick='toDetail("+item.id+")'>" + item.title + "</h3>";
                    str +="<div>" + item.pubdatetime + "</div><hr/>"
                    str +="<div>" + item.content.substr(0,30) + "...</div>";
                    str +="</li>";
                });
                $("#showtop").html(str);
            }
        }
    )
})
function toList(typeId) {
    localStorage.setItem("typeId" , typeId);
    alert(typeId);
    window.open('newsList.html',"_blank");
}
function toDetail(newsId) {
    localStorage.setItem("newsId",newsId);
    window.open("newsDetail.html","_blank");
}