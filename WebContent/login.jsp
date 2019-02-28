<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/login_register1.css" />
		<link rel="stylesheet" href="css/reset.css" />
		<link rel="stylesheet" href="layui/css/layui.css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/login.js"></script>
	</head>
	<body>
		<div class="bg">
			<img class="filter" src="img/other_img/23.jpg" />
			<div class="title">
				<br />
				<p class="layui-icon layui-icon-loading" style="font-size: 30px;">城市方寸田</p> 
			</div>
			<div class="login_form">
				<span class="ban"><i class="layui-icon layui-icon-close"></i>
					<span class="dian1"></span><span class="dian2"></span><span class="dian3"></span>
				</span>
				<span class="tou"><img src="img/other_img/default.png"/ id="userImg"></span>
					<p class="info">
					${param.message }
					</p>
				<form action="LoginServ" method="post" class="layui-form">
					<p><span class="layui-icon layui-icon-username input_ico"  style="font-size: 35px;"></span>
						<input class="text" autocomplete="off" name="id" id="userid" type="text" required="required" onkeyup="returnImg()"/></p>
						<br />
					<p><span class="layui-icon layui-icon-password input_ico" style="font-size: 35px;"></span>
						<input  class="text" autocomplete="off" name="password"  type="password" required="required"/></p>
					<p>
						<button class="button" lay-submit="" lay-filter="demo1"/>登陆</button>&nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp"><input type="button" class="button" value="注册" /></a>
					</p>
				</form>
				
			</div>
		</div>
	</body>
</html>