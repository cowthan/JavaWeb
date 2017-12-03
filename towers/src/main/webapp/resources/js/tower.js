var currentBucket = null;
var currentAK, currentSK;
var currentPage = 0;
var currentPageIndicator;

$(document).ready(function() {
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
	currentPage = pageNow;
	$.get('tower/list', {
		"pageNow": pageNow,
		"pageSize" : "9"
	 }, function(data, status) {
		 var res = JSON.parse(data);
		 if(status === "success"){
			 layer.msg("成功了！");
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
		html += '<img style="width:150px;height:150px;" src="{thumbUrl}" class="img-thumbnail" onclick="openPhoto(\'{wholeUrl}\');" /><br/><p>{content}</p>'
			+ "<br/>" 
			+ "<input type='button' value='delete' class=\"btn btn-warning\" onclick='deleteById(\"{ddddid}\");'>"
			;
		html += "</td>"
		
		if((i+1)%3 === 0){
			html += "</tr>";
		}
		
		//var url = files[i].thumb;
		//var url = files[i].thumb;
		var content = "运营商：" + files[i].gongsi 
			+ "<br />姓名：" + files[i].name 
			+ "<br />站点：" + files[i].stateName 
			+ "<br />发电机型号：" + files[i].motorType
			+ "<br />状态：" + files[i].status
			+ "<br />开始时间：" + files[i].startTime
			+ "<br />结束时间：" + files[i].endTime
			+ "<br />经度：" + files[i].lnt
			+ "<br />纬度：" + files[i].lat
			+ "<br />省市：" + files[i].city
			+ "<br />详细地址：" + files[i].addr
			;
		html = html.replace("{thumbUrl}", files[i].thumb);
		html = html.replace("{wholeUrl}", files[i].photo);
		html = html.replace("{content}", content);
		html = html.replace("{ddddid}", files[i].id);
		
		
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
	    area: ['800px', '600px'],
	    shade: 0.8,
	    closeBtn: true,
	    shadeClose: true,
	    content: url
	});
}

function deleteById(id){
	//alert(id);
	$.get('tower/delete', {
		"id": id
	 }, function(data, status) {
		 var res = JSON.parse(data);
		 if(status === "success"){
			 layer.msg("成功了！");
			 //location.reload();
			 loadImages(currentPage);
		 }else{
			 layer.alert("失败--" + res.message);
		 }
	 });
}
