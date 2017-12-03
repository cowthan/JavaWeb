<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
    	<base href="<%=basePath%>">
        <title>铁塔管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<!-- bootstrap和jquery -->
		<link href="<%=basePath %>resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    	<link href="<%=basePath %>resources/bootstrap/css/style.css" rel="stylesheet">
    	
    	<!-- 图片上传 -->

		<style type="text/css">
      .react_spinner {
        margin: 100px auto;
        width: 32px;
        height: 32px;
        position: relative;
      }

      .react_cube1, .react_cube2 {
        background-color: #4CAF50;
        width: 10px;
        height: 10px;
        position: absolute;
        top: 0;
        left: 0;

        -webkit-animation: cubemove 1.8s infinite ease-in-out;
        animation: cubemove 1.8s infinite ease-in-out;
      }

      .react_cube2 {
        -webkit-animation-delay: -0.9s;
        animation-delay: -0.9s;
      }

      @-webkit-keyframes cubemove {
        25% { -webkit-transform: translateX(42px) rotate(-90deg) scale(0.5) }
        50% { -webkit-transform: translateX(42px) translateY(42px) rotate(-180deg) }
        75% { -webkit-transform: translateX(0px) translateY(42px) rotate(-270deg) scale(0.5) }
        100% { -webkit-transform: rotate(-360deg) }
      }

      @keyframes cubemove {
        25% {
          transform: translateX(42px) rotate(-90deg) scale(0.5);
          -webkit-transform: translateX(42px) rotate(-90deg) scale(0.5);
        } 50% {
          transform: translateX(42px) translateY(42px) rotate(-179deg);
          -webkit-transform: translateX(42px) translateY(42px) rotate(-179deg);
        } 50.1% {
          transform: translateX(42px) translateY(42px) rotate(-180deg);
          -webkit-transform: translateX(42px) translateY(42px) rotate(-180deg);
        } 75% {
          transform: translateX(0px) translateY(42px) rotate(-270deg) scale(0.5);
          -webkit-transform: translateX(0px) translateY(42px) rotate(-270deg) scale(0.5);
        } 100% {
          transform: rotate(-360deg);
          -webkit-transform: rotate(-360deg);
        }
      }

      .react-qiniu-example .dropped-files img {
        max-width: 100px;
      }
    </style>
    <link rel="stylesheet" href="<%=basePath %>resources/react_qiniu/base-min.css" />

    	<!-- 图片上传：结束 -->
		
</head>
<body>
<!-- ================================body================================== -->
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h1 class="text-center">
				铁塔管理系统
			</h1>
			<p class="text-center"><a href="<%=basePath %>tower/excel">导出excel</a></p>
			<p class="text-center"><a href="<%=basePath %>tower/deleteAll">全部删除（慎点）</a></p>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
		</div>
		
		<div class="col-md-6">
			<div class="row">
				<!-- 图片列表和分页 -->
				<br/>
				<div class="col-md-12">
					<table class="table table-bordered">
						<tbody id="photo_container">
							<!-- <tr>
								<td>
									<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-thumbnail" />
								</td>
								<td>
									<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-thumbnail" />
								</td>
								<td>
									<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-thumbnail" />
								</td>
							</tr>
							<tr>
								<td>
									<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-thumbnail" />
								</td>
								<td>
									<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-thumbnail" />
								</td>
								<td>
									<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-thumbnail" />
								</td>
							</tr>
							<tr>
								<td>
									<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-thumbnail" />
								</td>
								<td>
									<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-thumbnail" />
								</td>
								<td>
									<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-thumbnail" />
								</td>
							</tr> -->
						</tbody>
					</table>
				</div>
				<ul class="pagination">
				<li>
					<a class="page_indicator" href="#">Prev</a>
				</li>
				<c:forEach varStatus="i" begin="0" end="${pageInfo.pageCount - 1 < 0 ? 0 : pageInfo.pageCount - 1}">
					<li>
						<a id="page_count_${i.count}" class="page_indicator" href="#">${i.count}</a>
					</li>
				</c:forEach>
				<li>
					<a class="page_indicator" href="#">Next</a>
				</li>
			</ul>
				
				<!-- 图片列表和分页：结束 -->
			</div>
		</div>
			<!-- 图片上传：react，结束 -->
		<div class="col-md-3">
		</div>
	</div>
</div>

<!-- ================================body================================== -->
	<script src="<%=basePath %>resources/bootstrap/js/jquery.min.js"></script>
    <script src="<%=basePath %>resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>resources/layer/layer.js"></script>
    <script src="<%=basePath %>resources/layer/extend/layer.ext.js"></script>
    <script src="<%=basePath %>resources/bootstrap/js/scripts.js"></script>
    <script src="<%=basePath %>resources/app/js/sbutils.js"></script>
    
    <script>
   
    </script>
    <script src="<%=basePath %>resources/app/js/tower.js"></script>
    
</body>
</html>
