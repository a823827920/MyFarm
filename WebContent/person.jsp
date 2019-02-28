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
		<script src="js/jquery.js"></script>
		<script src="layui/layui.js"></script>
		<script>
			layui.use('element', function() {
				var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

				//监听导航点击
				element.on('nav(demo)', function(elem) {
					//console.log(elem)
					layer.msg(elem.text());
				});
			});
			$(function (){
				$.ajax({
					type:"post",
					url:"LoadUserInfo",
					async:false,
					success:function(data)
					{
						var obj=eval("("+data+")");
						$("#name").val(obj.name);
						$("#tel").val(obj.tel);
						$("#email").val(obj.email);
						$("#des").val(obj.des);
						if(obj.sex=="女"){
							$("input[type='radio'][name='sex'][value='女']").prop('checked',true);
						}
					}
				})
			})
		</script>
	</head>
	<body>
		<div class="index_menu">
			<nav id="test11">
				<a href="index.jsp">HOME</a>
				<a href="zone.jsp">ZONE</a>
				<a href="store.jsp">STORE</a>
				<a href="contact.jsp">CONTACT</a>
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
		<div class="pcont">
			<div class="leftDiv">
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
					<li class="layui-nav-item"><a href="person.jsp"><i style="font-size: 1.5em;margin-right: 0.5em;" class="layui-icon layui-icon-set-fill"></i>基本设置</a></li>
					<li class="layui-nav-item"><a href="zone.jsp"><i style="font-size: 1.5em;margin-right: 0.5em;" class="layui-icon layui-icon-component"></i>植物空间</a></li>
				</ul>
			</div>
			<div class="rightDiv">
				<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
					<ul class="layui-tab-title">
						<li class="layui-this">我的资料</li>
						<li>头像</li>
						<li>密码</li>
					</ul>
					<div class="layui-tab-content">
						<!-- 我的资料 -->
						<div class="layui-tab-item layui-show">
							<form class="layui-form" action="">
								<div class="layui-form-item layui-inline">
									<label class="layui-form-label">昵称</label>
									<div class="layui-input-block">
										<input type="text" id="name" name="name" required lay-verify="username" placeholder="请输入标题" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-form-item">
										<label class="layui-form-label">绑定手机号</label>
										<div class="layui-input-inline">
											<input type="text" id="tel" name="tel" lay-verify="required|phone" autocomplete="off" class="layui-input">
										</div>
									</div>
									<div class="layui-form-item">
										<label class="layui-form-label">验证邮箱</label>
										<div class="layui-input-inline">
											<input type="text" id="email" name="email" lay-verify="email" autocomplete="off" class="layui-input">
										</div>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">性别</label>
									<div class="layui-input-block" id="sex">
										<input type="radio" name="sex" value="男" title="男" checked>
										<input type="radio" name="sex" value="女" title="女" >
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">个性签名</label>
									<div class="layui-input-block">
										<textarea name="des" id="des" placeholder="请输入内容" class="layui-textarea"></textarea>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-input-block">
										<button class="layui-btn" lay-submit lay-filter="formDemo">确认修改</button>
									</div>
								</div>
							</form>
						</div>
						<!-- end -->
						<!-- 头像 -->
						<div class="layui-tab-item">
							<div class="upload_img">
								<button type="button" class="layui-btn" id="test2">
									<i class="layui-icon">&#xe67c;</i>上传头像
								</button>
								<p>建议尺寸168*168，支持jpg、png、gif，最大不能超过50KB</p>
								<span><img class="layui-upload-img" id="demo2"></span>
								<form class="layui-form" action="">
								      <input type="hidden" name="img" id="img">
								      <button class="layui-btn" lay-submit="" lay-filter="formDemo1" style="margin-top:10px;">保存头像</button>
								 </form>
							</div>
						</div>
						<!-- end -->
						<!-- 密码 -->
						<div class="layui-tab-item">
							<form class="layui-form" action="">
								<div class="layui-form-item">
									<label class="layui-form-label">请输入密码</label>
									<div class="layui-input-inline">
										<input type="password" name="password" id='pas' required lay-verify="pass" placeholder="请输入密码" autocomplete="off"
										 class="layui-input">
									</div>
									<div class="layui-form-mid layui-word-aux">请填写6-16个字符</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">确认密码</label>
									<div class="layui-input-inline">
										<input type="password" name="repassword" id='repas' required lay-verify="repas" placeholder="请输入密码"
										 autocomplete="off" class="layui-input">
									</div>
									<div class="layui-form-mid layui-word-aux">请填写6-16个字符</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-input-block">
										<button class="layui-btn" lay-submit lay-filter="formDemo2">确认修改</button>
									</div>
								</div>
							</form>
						</div>
						<!-- end -->
					</div>
				</div>
			</div>
		</div>
		<div class="foot_box"><p>Copyright ©2018 author-丁权</p></div>
		<script>
			layui.use('upload', function() {
				var $ = layui.jquery
				  ,upload = layui.upload;

				//执行实例
				var uploadInst = upload.render({
					elem: '#test2' //绑定元素
						,
					url: 'Upload' //上传接口
					,before: function(obj){
					//预读本地文件示例，不支持ie8
						obj.preview(function(index, file, result){
						$('#demo2').attr('src', result); //图片链接（base64）
						   });
					},
					done: function(res) {
						//上传完毕回调
						$("#img").val(res.data);
					},
					error: function() {
						layer.msg('error');
					}
				});
			});
		</script>
		<script>
			//Demo
			layui.use('form', function() {
				var form = layui.form;

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
						}

						//我们既支持上述函数式的方式，也支持下述数组的形式
						//数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
						,
					repas: function(value) {
						if ($('#pas').val() != value) {

							return '两次输入密码不相符';
						} 
					},
					pass: [
						/^[\S]{6,12}$/, '密码必须6到12位，且不能出现空格'
					]

				});
							//监听提交
							form.on('submit(formDemo)', function(data) {
								var $=layui.$;
					            $.ajax({
					                url: '${pageContext.request.contextPath}/SetUserInfo',
					                type: 'post',
					                async:false,
					                data: {
					                	map: JSON.stringify(data.field)
					                } ,
					                dataType: 'json',
					                success: function(result){
					                    if(result=='1'){
					                        layer.msg('修改成功！', {icon: 6});
					                        setTimeout(function(){
					                            location.reload();
					                        }, 1000);
					                    }else{
					                        layer.msg('操作失败', {icon: 5});
					                    }
					                } ,
					                error: function(){
					                    alert("网络忙，请稍后重试！");
					                },complete: function () {
					                    layer.closeAll('loading');
					                }
					            });
					            return false;
							});
							form.on('submit(formDemo1)', function(data) {
								var $=layui.$;
					            $.ajax({
					                url: '${pageContext.request.contextPath}/SetUserImg',
					                type: 'post',
					                async:false,
					                data: {
					                	map: JSON.stringify(data.field)
					                } ,
					                dataType: 'json',
					                success: function(result){
					                    if(result=='1'){
					                        layer.msg('修改成功！', {icon: 6});
					                        setTimeout(function(){
					                            location.reload();
					                        }, 1000);
					                    }else{
					                        layer.msg('操作失败', {icon: 5});
					                    }
					                } ,
					                error: function(){
					                    alert("网络忙，请稍后重试！");
					                },complete: function () {
					                    layer.closeAll('loading');
					                }
					            });
								return false;
							});
							form.on('submit(formDemo2)', function(data) {
								var $=layui.$;
					            $.ajax({
					                url: '${pageContext.request.contextPath}/SetUserPassword',
					                type: 'post',
					                async:false,
					                data: {
					                	map: JSON.stringify(data.field)
					                } ,
					                dataType: 'json',
					                success: function(result){
					                    if(result=='1'){
					                        layer.msg('修改成功！', {icon: 6});
					                        setTimeout(function(){
					                            location.reload();
					                        }, 1000);
					                    }else{
					                        layer.msg('操作失败', {icon: 5});
					                    }
					                } ,
					                error: function(){
					                    alert("网络忙，请稍后重试！");
					                },complete: function () {
					                    layer.closeAll('loading');
					                }
					            });
								return false;
							});
						});
					</script>
					<script>
						//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
						layui.use('element', function() {
							var element = layui.element;
					
							//…
						});
					</script>
	</body>
</html>
