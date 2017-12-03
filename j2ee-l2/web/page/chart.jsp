<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  
  </head>
  
  <body name="aa">
  
    <form action="sendChart" name="form1">
     <TextArea name="message" rows="6" cols="30"></TextArea>
     <input type="submit" value="发送 " name="submit">
    </form>
  <%
     String message=(String)request.getAttribute("list1");
        if(message!=null){%>
                    消息记录:<br/>
        <TextArea rows="6" cols="30"><%=message %></TextArea>
   <%   }
      %>
      
      
  
  </body>
</html>
<script type="text/javascript">
  setTimeout(function(){location.href="getChart";},3000);
</script>