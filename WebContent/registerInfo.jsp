<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="layui/css/layui.css" />
		<link rel="stylesheet" href="css/menu.css" />
		<link rel="stylesheet" href="css/personSet.css" />
	</head>
	<body>
		<div class="index_menu">
			<nav id="test11">
				<a href="index.jsp">HOME</a>
				<a href="zone.jsp">ZONE</a>
				<a href="store.jsp">STORE</a>
				<lable>|</label>
					<%
						if(session.getAttribute("user")==null){
					%>
						<span onclick="window.location.href='login.jsp';">&nbsp;&nbsp;未登录</span><i><img src="img/add_img/wlog.png" onclick="window.location.href='login.jsp';" /></i>
					<%
						}else{
					%>
						<span><img src="/img/other_img/${user.img }" />&nbsp;&nbsp;${user.name }</span>
					<%} %>
						<i><img onclick="window.location.href='LogoutServ';" src="img/add_img/exit.png" /></i>&nbsp;&nbsp;
			</nav>
		</div>
		<div class="tip_box">
			<p>您的登录账号为：${id}</p>
			<p>请妥善保管您的登录账号!</p>
			<a href="index.jsp"><button class="layui-btn layui-btn-warm">转至首页</button></a>
		</div>
		<div class="foot_box">
			<p>Copyright ©2018 author-佚名</p>
		</div>
	</body>
</html>
