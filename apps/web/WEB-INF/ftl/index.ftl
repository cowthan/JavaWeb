<#assign base=request.contextPath />
<html>
<head>
    <meta charset="utf-8">
  <title>Welcome!</title>
    <base id="base" href="${base}">
    <link href="${base}/resource/css/common.css" rel="stylesheet">
</head>
<body>
<h1>
  Welcome ${user}<#if user == "Big Joe">, our beloved leader</#if>! 打发是的发顺丰
</h1>
</body>
<script>
    var base = document.getElementById("base").href;
</script>
</html>