<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>servlet学习</title>
<style>
	.content{
		margin:100px auto;
		width:300px;
		height:150px;
		text-align:center;
		background:#eee;
	}
	h1{
		color:#f00;
	}
</style>
</head>
<body>
	<div class="content">
		<h1>login</h1>
		<!-- 1.表单的提交动作，将会触发login的servlet里面的dopost方法 -->
		<form action="login" name="login_f" method="post">
			username:<input type="text" name="user" value="soulsjie"/><br/>
			password:<input type="password" name="pass" value="soulsjie"/><br/>
			<input type="submit" value="提交">
		</form>
	</div>
</body>
</html>