<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<link rel="stylesheet" href="layui/css/layui.css" />
	<link rel="stylesheet" href="css/login_register.css" />
	<link rel="stylesheet" href="css/menu.css" />
	<link rel="stylesheet" href="css/foot.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/verify.js"></script>
	<script type="text/javascript" src="layui/layui.js"></script>

	<body>
		<!--头部引用-->
		<div class="bc">
			<div class="index_menu">
				<nav id="test1">
					<a href="index.jsp" style="color: greenyellow;">HOME</a>
					<a href="zone.jsp">ZONE</a>
					<a href="store.jsp">STORE</a>
					<a href="contact.html">CONTACT</a>

				</nav>
			</div>
			<span class="tit">欢迎注册！</span>
		</div>
		<!--end-->

		<div class="form_content">
			<form class="layui-form" action="RegisterServ" method="post" onsubmit="return mySubmit();">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">昵称：</label>
						<div class="layui-input-inline">
							<input type="text" name="name" lay-verify="username" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">密码：</label>
					<div class="layui-input-inline">
						<input type="password" name="password" lay-verify="pass" id="pass"  autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">确认密码：</label>
					<div class="layui-input-inline">
						<input type="password" name="repass" lay-verify="repass"  autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">手机号：</label>
						<div class="layui-input-inline">
							<input type="tel" name="tel" lay-verify="required|phone" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">电子邮箱：</label>
						<div class="layui-input-inline">
							<input type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>

				<!--
					<div class="layui-form-item">
						<label class="layui-form-label">倾向类型</label>
						<div class="layui-input-block">
							<input type="checkbox" name="like[write]" title="农作物">
							<input type="checkbox" name="like[read]" title="花卉" checked="">
							<input type="checkbox" name="like[game]" title="树木">
						</div>
					</div>
					-->
				<div class="layui-form-item">
					<label class="layui-form-label">单选框</label>
					<div class="layui-input-block">
						<input type="radio" name="sex" value="男" title="男" checked="">
						<input type="radio" name="sex" value="女" title="女">
						<!--<input type="radio" name="sex" value="禁" title="禁用" disabled="">-->
					</div>
				</div>
				<div class="layui-form-item">

					<div id="mpanel1">
					</div>

				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
		<div class="mid_right">
			<img src="img/other_img/23.jpg" />
			<img src="img/other_img/23.jpg" />

		</div>

		<div class="footer">
			<div class="conta">
				<div class="layui-row layui-col-space10 pet">
					<div class="layui-col-xs3">
						<p><label>城</label>市方寸田 </p>
					</div>
					<div class="layui-col-xs4">
						<p class="hr">联系信息</p>
						<br /><br />
						<p style="font-size: 1em;">致电我们</p>
						<label class="ltel">
 	   						+1234567891
 	   					</label>
					</div>
					<div class="layui-col-xs2">
						<p class="hr">导航</p>
						<br /><br />
						<ul>
							<li><i class="layui-icon layui-icon-right" style="font-size: 15px; color: #fff;"></i> Home</li>
							<li><i class="layui-icon layui-icon-right" style="font-size: 15px; color: #fff;"></i> Blog</li>
							<li><i class="layui-icon layui-icon-right" style="font-size: 15px; color: #fff;"></i> About</li>
							<li><i class="layui-icon layui-icon-right" style="font-size: 15px; color: #fff;"></i> Contact</li>
						</ul>
					</div>
					<div class="layui-col-xs3">
						<p class="hr">推荐</p><br /><br />
						<p><label>植</label>物空间</p>
					</div>
				</div>
			</div>
			<div class="footr">
				<div class="mi">
					<p>Copyright ©2018 author-丁权</p>
				</div>
			</div>
		</div>

	</body>
	<script>
		var result = false;
		$('#mpanel1').slideVerify({
			type: 1, //类型
			vOffset: 5, //误差量，根据需求自行调整
			barSize: {
				width: '80%',
				height: '40px',
			},
			ready: function() {},
			success: function() {
				result = true;
				//alert('验证成功，添加你自己的代码！');
				//......后续操作
			},
			error: function() {
				result = false;
				//		        	alert('验证失败！');
			}

		});

		function mySubmit() {
			return result;
		}
		layui.use(['form', 'layedit', 'laydate'], function() {
			var form = layui.form,
				layer = layui.layer,
				layedit = layui.layedit,
				laydate = layui.laydate;

			//日期
			laydate.render({
				elem: '#date'
			});
			laydate.render({
				elem: '#date1'
			});

			//创建一个编辑器
			var editIndex = layedit.build('LAY_demo_editor');

			//自定义验证规则
			form.verify({
				username: function(value, item) { //value：表单的值、item：表单的DOM对象
					if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
						return '用户名不能有特殊字符';
					}
					if (/(^\_)|(\__)|(\_+$)/.test(value)) {
						return '用户名首尾不能出现下划线\'_\'';
					}
					if (/^\d+\d+\d$/.test(value)) {
						return '用户名不能全为数字';
					}
					if (value.length < 3) {
						return '至少3个字符';
					}
				},
				title: function(value) {
					if(value.length < 5) {
						return '标题至少得5个字符啊';
					}
				},
				pass: [/(.+){6,12}$/, '密码必须6到12位'],
				repass: function(value) {
					//获取密码
					var pass = $("#pass").val();
					if(value!=pass) {
					return '两次输入的密码不一致';
					}
				},
				content: function(value) {
					layedit.sync(editIndex);
				}
			});

			//监听指定开关
			form.on('switch(switchTest)', function(data) {
				layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
					offset: '6px'
				});
				layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
			});

		});
	</script>

</html>