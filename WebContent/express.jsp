<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css" />
	</head>
	<body>
		<fieldset class="layui-elem-field" style="margin: 20px;">
			<legend>收货人信息</legend>
			<div class="layui-field-box">
				<form class="layui-form" action="Odering" method="post">
					<div class="layui-form-item">
					 	<input type="hidden" name="id">
						<div class="layui-input-inline">
							<input type="text" name="name" required lay-verify="required" placeholder="联系人名称" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline">
							<input type="tel" name="tel" required lay-verify="required|phone" placeholder="联系人电话" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<!-- <label class="layui-form-label">选择地区</label> -->
						<div class="layui-input-inline">
							<select name="P1" lay-filter="province">
								<option></option>
							</select>
						</div>
						<div class="layui-input-inline">
							<select name="C1" lay-filter="city">
								<option></option>
							</select>
						</div>
						<div class="layui-input-inline">
							<select name="A1" lay-filter="area">
								<option></option>
							</select>
						</div>
						<div class="layui-input-inline">
							<br />
							<input type="text" name="area" required lay-verify="required" placeholder="详细地址" autocomplete="off" class="layui-input">
							<br />
							<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						</div>
					</div>
				</form>
			</div>
		</fieldset>


		<script src="js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>
		
		<script type="text/javascript" src="layui/lay/layui.all.js"></script>
		<script src="js/citys.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			pca.init('select[name=P1]', 'select[name=C1]', 'select[name=A1]', '北京', '北京', '朝阳区');
		</script>
		<!--  <script type="text/javascript" src="layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript">
		layui.use(['form', 'layedit', 'laydate'], function(){
		    	var form = layui.form
		        ,layer = layui.layer
		        ,layedit = layui.layedit
		        ,laydate = layui.laydate;
		        //自定义验证规则  对应：lay-verify="menuSort"
		        form.verify({
		            
		        });

		        //注意：parent 是 JS 自带的全局对象，可用于操作父页面
		        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		        //监听提交
		        form.on('submit(demo1)', function(data){
		            var $=layui.$;
		            $.ajax({
		                url: '${pageContext.request.contextPath}/Odering',
		                type: 'post',
		                async:false,
		                data: {
		                	map: JSON.stringify(data.field)
		                } ,
		                dataType: 'json',
		                success: function(result){
		                    if(result=='1'){
		                        layer.msg('操作成功....', {icon: 6});
		                        setTimeout(function(){
		                            parent.layer.close(index);
		                            parent.location.reload();
		                        }, 1000);
		                    }else{
		                        layer.msg('操作失败', {icon: 5});
		                    }
		                } ,
		                error: function(){
		                },complete: function () {
		                    layer.closeAll('loading');
		                }
		            });
		            return false;
		        });
		    });
		</script>
		-->
	</body>
</html>
