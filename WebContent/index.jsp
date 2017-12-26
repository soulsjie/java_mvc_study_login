<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="service_yewuceng.login_service"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>servlet学习</title>
<style>
	.content{margin:100px auto;width:300px;height:150px;text-align:center;background:#eee;}
	h1{color:#f00;}
	.tb{border:1px solid #f00;width:100%;height:auto;border-collapse: collapse;}
	.tb th{background:#000;color:#fff;}
	.tb td{border:1px solid #f00;text-align:center; }
	.tb tr:nth-child(odd){background:#eee;}
	
	.atc{height:100px;width:300px;margin:20px auto;background:#eee;}
	.atcL{float:left;width:100px;height:100px;}
	.atcL img{height:80px;width:80px;}
	.atcR{float:right;width:200px;height:100px;}
</style>
</head>
<body>
	<div class="content">
		<h1>login</h1>
		<form action="login?op=login" name="login_f" method="post">
			username:<input type="text" name="user" value="soulsjie"/><br/>
			password:<input type="password" name="pass" value="soulsjie"/><br/>
			<input type="submit" value="提交">
		</form>
	</div>
	<a href="login?op=del">删除用户信息</a>
	<a href="AddUser.jsp">添加用户信息</a>
	<a href="login?op=show">显示用户信息</a>
	<table class="tb">
		<th width="25%">编号</th>
		<th width="25%">用户名</th>
		<th width="25%">密码</th>
		<th width="25%">编辑</th>
		<%login_service.show();
		for(int i = 0 ; i < login_service.userid.size() ; i++) {%>
		<tr>
			<td><%=login_service.userid.get(i) %></td>
			<td><%=login_service.username.get(i) %></td>
			<td><%=login_service.userpass.get(i) %></td>
			<td><a href="aa.jsp?aa=<%=login_service.userid.get(i) %>">del</a></td>
			</tr>
		<%}%> 
		<%if(1==0){%>
			<tr><td>没有数据</td></tr>
		<%} %>
	</table>
	<%for(int i = 0 ; i < 5; i++) { %>
	 	<div class="atc">
	 		<div class="atcL"><img src="images/test.jpg"></div>
	 		<div class="atcR"><h1><%=login_service.username.get(i) %></h1><p><%=login_service.userpass.get(i) %></p></div>
	 	</div>
	 <%}%> 
</body>
</html>