var currentBucket = null;
var currentAK, currentSK;
var currentPage = 0;
var currentPageIndicator;

$(document).ready(function() {
	
	$("#btn_load_from_qiniu").click(function(){
		$.get('localImage/loadImagesFromQiniu', {
			"aa" : "aa"
		}, function(data, status) {
			var res = JSON.parse(data);
			if(status === "success"){
				//layer.msg("成功了！");
				//fillPhotos(res.result);
				loadImages(0);
			}else{
				layer.alert("失败--" + res.message);
			}
		});
		return false;
	});
	$(".page_indicator").click(function(){
		var pageNow = $(this).text();
		if(pageNow === "Prev"){
			pageNow = currentPage - 1;
			if(pageNow < 0){
				return false;
			}
		}else if(pageNow === "Next"){
			pageNow = currentPage + 1;
//			if(pageNow > 100){
//				return;
//			}
		}else{
			pageNow = parseInt(pageNow) - 1;
		}
		loadImages(pageNow);
		currentPage = pageNow;
		var lastPageIndicator = currentPageIndicator;
		currentPageIndicator = $("#page_count_" + (currentPage+1));
		
		//---样式
		if(lastPageIndicator){
			lastPageIndicator.css({ 
				 "color":"#337ab7", 
				 "background­color":"#fff"
			});
		}
		currentPageIndicator.css({ 
			 "color":"#994422", 
			 "background­color":"#449922"
		});
		///----
		
		return false;
	});
	///默认分页的样式：color:#337ab7;text-decoration:none;background-color:#fff
	///当前的样式：
	
	loadImages(0);
});

function loadImages(pageNow){
	$.get('localImage/getPhotos', {
		"pageNow": pageNow,
		"pageSize" : "9"
	 }, function(data, status) {
		 var res = JSON.parse(data);
		 if(status === "success"){
			 //layer.msg("成功了！");
			 fillPhotos(res.result);
		 }else{
			 layer.alert("失败--" + res.message);
		 }
	 });
}

function onPageClick(pageNow){
	loadImages(pageNow);
	return false;
}

function fillPhotos(files){
	///logger(JSON.stringify(files));
	var html = "";
	for (var i = 0; i < files.length; i++) {
		//0--8
		//0,1,2  3,4,5  6,7,8
		if(i%3 === 0){
			html += "<tr>";
		}
		
		html += "<td>";
		html += '<img src="{thumbUrl}" style="{width:400;height:400;}" class="img-thumbnail" onclick="openPhoto(\'{wholeUrl}\');" /><br/><p>{txt}</p>';
		html += "</td>"
		
		if((i+1)%3 === 0){
			html += "</tr>";
		}
		
		var type = files[i].type;
		var url = files[i].url;
		url = "http://localhost:8080/ipiapia/" + "localImage/getPhoto?path=" + url;
		html = html.replace("{thumbUrl}", url);
		html = html.replace("{wholeUrl}", files[i].url);
		html = html.replace("{txt}", files[i].qiniuKey + "<br/>" + files[i].thumbBig);
	}
	$("#photo_container").empty();
	$(html).appendTo($("#photo_container"));
	
	
}

function openPhoto(url){
	$.get('localImage/delete?path=' + url, {
		"pathddd": "dd"
	 }, function(data, status) {
		 var res = JSON.parse(data);
		 layer.alert("ok");
	 });
}