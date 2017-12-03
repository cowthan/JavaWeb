<%@ page language="java" import="java.util.*,aa.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
    
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
    当前在线用户为：
    <br/>
    <%
       Map map=(Map)session.getServletContext().getAttribute("map");
       if(map!=null){
       Set key=map.keySet();
       for(Iterator it=key.iterator();it.hasNext();){
      
       //System.out.println((String)it.next());
        HttpSession s=(HttpSession)map.get((String)it.next());
        String name=(String)s.getAttribute("name");
       
        
      
       
     
    %>
    <%=name %> &nbsp;&nbsp;&nbsp; <a href="kicOut?name=<%=name %>">退出系统</a><br/>
    <%}
    } %>
  
        
  </body>
</html>
<script type="text/javascript">
  setTimeout(function(){location.href="admin.jsp";},5000);
</script>