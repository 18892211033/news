$(function () {
    var typeId = localStorage.getItem("typeId");
    alert(typeId);
    $.get(
        'news?param=getAllByTypeId&typeId='+typeId,
        function (reqData) {
            alert(reqData);
            console.log(reqData);
            var typeObj= JSON.parse(reqData);
            if (0 == typeObj.errCode) {
                newsArr2 = typeObj.data;
                var str = "";
                $.each(newsArr2, function (index, item) {
                    str += "<li onclick='toList(" + item.id + ")'>";
                    str += "<p>"
                    str += item.title +"</p>";
                    str += "<p>"
                    str += item.pubdatetime+"</p>";
                    str += "<p>"
                    str += item.content+"</p>";
                    str += "</li>";
                });
                $("#shownewsbyid").html(str);
             }
        }
    );
})