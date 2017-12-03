var currentBucket = null;
var currentAK, currentSK;
var currentPage = 0;
var currentPageIndicator;

$(document).ready(function() {
	
	$("#btn_load_from_qiniu").click(function(){
		$.get('loadImagesFromQiniu', {
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
	$.get('getPhotos', {
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
		html += '<img src="{thumbUrl}" class="img-thumbnail" onclick="openPhoto(\'{wholeUrl}\');" />';
		html += "</td>"
		
		if((i+1)%3 === 0){
			html += "</tr>";
		}
		
		var type = files[i].type;
		var thumbUrl = "";
		var url = "";
		if(type == 1){
			thumbUrl = files[i].thumbMiddle;
			url = files[i].url;
		}else if(type == 2){
			thumbUrl = files[i].thumbMiddle;
			url = files[i].url;
		}else if(type == 3){
			thumbUrl = files[i].thumbMiddle;
			url = files[i].url;
		}
		html = html.replace("{thumbUrl}", thumbUrl);
		html = html.replace("{wholeUrl}", url);
	}
	$("#photo_container").empty();
	$(html).appendTo($("#photo_container"));
	
	
}

function openPhoto(url){
	var img = '<img src="{wholeUrl}"  />';
	img = img.replace("{wholeUrl}", url);
	layer.open({
	    type: 2,
	    title: url,
	    //area: ['630px', '360px'],
	    shade: 0.8,
	    closeBtn: true,
	    shadeClose: true,
	    content: url
	});
}