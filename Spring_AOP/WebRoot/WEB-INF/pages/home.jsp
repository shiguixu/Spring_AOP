<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
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
  		<table border="1" style="border-spacing: 0px;">
  			<tr>
  			<th>编号：</th>
  			<th>姓名</th> 
  			<th>操作</th> 
  			</tr>
  		<c:forEach items="${users}" var="user">
  			<tr>
  			<th>${user.uid}</th>
  			<th>${user.uname}</th> 
  			<th><a href="deleteuser.action?uid=${user.uid}">删除</a></th> 
  			</tr>
  		</c:forEach>
  		</table>
    <s:debug/>
    	<h1>添加用户</h1>
    <form action="adduser.action" method="post">
    	<table border="1" style="border-spacing: 0px;">
  			<tr>
  			<th>姓名:<input type="text" name="uname" value=""> </th> 
  			<th>密码：<input type="password" value="123" name="upswd">   </th>
  			<th>职位：<input type="text" name="urid" value="3">  </th>
  			<th><input type="submit" value="添加用户"> </th>
  			</tr>
  		</table>
    </form>
  </body>
</html>
