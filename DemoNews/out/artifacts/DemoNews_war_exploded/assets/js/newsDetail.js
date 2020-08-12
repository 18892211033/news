$(function() {
    //获取新闻的id
    var newsId = localStorage.getItem("newsId");
    if (newsId == ""){
        window.close();
        return ;
    }
    $.get(
        'news?param=byId&newsId=' + newsId,
        function (reqData) {
            console.log(reqData);
            newsObj = JSON.parse(reqData);
            if(0 == newsObj.errCode){
                $("#showTitle").html(newsObj.data.title);
                $("#showDt").html(newsObj.data.pubdatetime);
                $("#showFrom").html(newsObj.data.comefrom);
                $("#showContent").html(newsObj.data.content);
            }
        }
    )
})