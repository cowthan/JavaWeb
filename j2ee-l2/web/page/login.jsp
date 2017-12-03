<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <center>
     <form action="login" method="post">
      <table>
        <tr><td>用户名：<input type="text" name="name"></td></tr>
        <tr><td>密&nbsp; 码：<input type="password" name="pwd"></td></tr>
        <tr><td align="center"><input type="submit" name="submit" value="提交">
                               <input type="reset" name="submit" value="重置"></td></tr>
      </table>
     </form>
   </center>
  </body>
</html>
