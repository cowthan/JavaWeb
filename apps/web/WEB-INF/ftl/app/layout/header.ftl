<#assign base=request.contextPath />
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>${title}</title>
    <base id="base" href="${base}">
    <meta name="description" content="Tinker 平台提供 Android APP 热更新服务，APP 接入 Tinker 平台后，可以随时下发补丁包，实时更新APP">
    <link rel="stylesheet" href="${base}/resource/css/bootstrap.min.css?v=1.2" />
    <link rel="stylesheet" href="${base}/resource/css/main.css?v=1.4" />
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
    <link rel="shortcut icon" href="${base}/resource/img/tinker/favicon.ico" type="image/x-icon" />
  </head>

  <body>
  <script src="${base}/resource/js/jquery-1.11.3.min.js"></script>
  <script src="${base}/resource/js/bootstrap.min.js?v=1.2"></script>
  <script src="${base}/resource/js/bootstrap3-typeahead.min.js"></script>
  <script src="${base}/resource/js/uglify.min.js"></script>
  <script src="${base}/resource/js/raphael.min.js"></script>
  <script src="${base}/resource/js/morris.min.js"></script>
      <div class="hd">
          <div class="wrapper">
              <a href="/" class="logo-tinker"></a>
              <ul>
                <li><a href="${base}/login"  class="selected">登录</a></li>
                <li><a href="${base}/user/info" class="">我的帐号</a></li>
                <li><a href="${base}/download" class=""> SDK下载 </a></li>
                <li><a href="" class=""> 文档 </a></li>
                <li><a href="${base}/user/bill" class="">账单</a></li>
                <li><a href="${base}/price" class="">价格</a></li>
                <li><a href="${base}/app/list" class="">我的App</a></li>
              </ul>
          </div>
      </div>

