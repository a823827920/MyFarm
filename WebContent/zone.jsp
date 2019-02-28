<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<link rel="stylesheet" href="css/foot.css" />
	<link rel="stylesheet" href="css/new_diary.css" />
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/menu.css" />
	<link rel="stylesheet" href="layui/css/layui.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/friend_lan.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/pack.js"></script>
	<script type="text/javascript">
	$(function(){
		$.ajax({
			type:'get',
			url:'GetZone',
			success:function(data)
			{
				var obj=eval("("+data+")");
				for(var i=0;i<obj.length;i++)
					{
						if(obj[i].flag==1){
							$("#list").append('<div class="layui-col-xs3">\
									<span><a href=diary.jsp?field_id='+obj[i].field_id+'>\
									<img src=/img/other_img/'+obj[i].plant.img+' >\
									<div class="hov">'+obj[i].plant.name+'</div>\
								</a></span>\
								<label>'+(obj[i].date.year+1900)+'-'+(obj[i].date.month+1)+'-'+(obj[i].date.date)+'</label>\
							</div>');
						}else{
							$("#list").append('<div class="layui-col-xs3">\
									<span>\
									<img style="filter: grayscale(0.9);" src=/img/other_img/'+obj[i].plant.img+' >\
									<div class="hov">'+obj[i].plant.name+'</div>\
								</a></span>\
								<label>正在种植</label>\
							</div>');
						}						
					}
			}
		})
	})
	</script>
	<script type="text/javascript">
	$(function(){
		$.ajax({
			type:"get",
			url:"QueryStoreServ",
			async: false,
			success:function(data)
			{
				var jsonObj=eval("("+data+")");
				for(var i=0;i<jsonObj.length;i++)
					{
						$("#plantStore").append($("<li><img data-pid='"+jsonObj[i].plant.id+"' class='clic' data-method='offset2' data-num='"+jsonObj[i].plant_num+"' data-price='"+jsonObj[i].plant.salePrice+"' src='/img/other_img/"+jsonObj[i].plant.img+"'><label>库存：<strong>"+jsonObj[i].plant_num+"</strong>单位</label><span class='hover_seeds'><p>"+jsonObj[i].plant.name+"&nbsp;&nbsp;&nbsp;&nbsp;"+jsonObj[i].plant.des+"</p></span></li>"));
						$("#plantStore2").append($("<li><img data-pid='"+jsonObj[i].plant.id+"' class='clic' data-method='offset2' data-num='"+jsonObj[i].plant_num+"' data-price='"+jsonObj[i].plant.salePrice+"' src='/img/other_img/"+jsonObj[i].plant.img+"'><label>库存：<strong>"+jsonObj[i].plant_num+"</strong>单位</label><span class='hover_seeds'><p>"+jsonObj[i].plant.name+"&nbsp;&nbsp;&nbsp;&nbsp;"+jsonObj[i].plant.des+"</p></span></li>"));
						//alert(jsonObj[i].item_id+" "+jsonObj[i].plant_num+" "+jsonObj[i].user_id);
					}
			}
		})
	})
	$(function(){
		$.ajax({
			type:"get",
			url:"GetCrop",
			async: false,
			success:function(data)
			{
				var jsonObj=eval("("+data+")");
				for(var i=0;i<jsonObj.length;i++)
					{
						$("#crop").append($("<li><img data-cid='"+jsonObj[i].id+"' class='clic' data-method='offset3'  src='/img/other_img/"+jsonObj[i].plant.img+"'><label>重量：<strong>"+jsonObj[i].weight+"</strong>kg</label><span class='hover_seeds'><p>"+jsonObj[i].plant.name+"&nbsp;&nbsp;&nbsp;&nbsp;"+jsonObj[i].plant.des+"</p></span></li>"));
						$("#crop1").append($("<li><img data-cid='"+jsonObj[i].id+"' class='clic' data-method='offset3'  src='/img/other_img/"+jsonObj[i].plant.img+"'><label>重量：<strong>"+jsonObj[i].weight+"</strong>kg</label><span class='hover_seeds'><p>"+jsonObj[i].plant.name+"&nbsp;&nbsp;&nbsp;&nbsp;"+jsonObj[i].plant.des+"</p></span></li>"));
					}
			}
		})
	})
	</script>
	<body>
		<!--头部引用-->
		<div class="bc">
			<div class="index_menu">
				<nav id="test1">
					<a href="index.jsp">HOME</a>
					<a href="#" style="color: greenyellow;">ZONE</a>
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
							<span><img style="cursor: pointer" onclick="window.location.href='person.jsp';" src="/img/other_img/${user.img }" />&nbsp;&nbsp;${user.name }</span>
						<%} %>
						<i><img onclick="window.location.href='LogoutServ';" src="img/add_img/exit.png" /></i>&nbsp;&nbsp;
						<i><img id="pack" src="img/add_img/pack.png" class="clic"/></i>
						<i><img data-method="offset1" data-type="auto" class="clic" src="img/add_img/qd.png" />
							<div class="coin">余额：${user.money}<i><img src="img/add_img/coin.png"></i></div>
						</i>
				</nav>
			</div>
			<div id="test0">
			<div class="index_menu">
				<nav id="test11">
					<a href="index.jsp">HOME</a>
					<a href="#" style="color: greenyellow;">ZONE</a>
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
							<span><img style="cursor: pointer" onclick="window.location.href='person.jsp';" src="/img/other_img/${user.img }" />&nbsp;&nbsp;${user.name }</span>
						<%} %>
						<i><img onclick="window.location.href='LogoutServ';" src="img/add_img/exit.png" /></i>&nbsp;&nbsp;
							<i><img id="pack1" src="img/add_img/pack.png" class="clic"/></i>
							<i><img data-method="offset1" data-type="auto" class="clic" src="img/add_img/qd.png" />
							<div class="coin">余额：${user.money}<i><img src="img/add_img/coin.png"></i></div>
							</i>
				</nav>
			</div>
			</div>
			<span class="tit">植物空间！</span>
		</div>
		<!-- 我的背包 -->
		<div class="pack_show">
			<p class="seed_title">种子（点击图片可种植）</p>
			<hr class="layui-bg-green hr_width"/>
			<ul id="plantStore">
				
			</ul>
			<p class="seed_title2">成熟作物（点击图片可配送）</p>
			<hr class="layui-bg-green hr_width"/>
			<ul id="crop">
				
			</ul>
		</div>
		<!--end-->
				<!-- 我的背包2 -->
		<div class="pack_show2">
			<p class="seed_title">种子（点击图片可种植）</p>
			<hr class="layui-bg-green hr_width"/>
			<ul id="plantStore2">
				
			</ul>
			<p class="seed_title2">成熟作物（点击图片可配送）</p>
			<hr class="layui-bg-green hr_width"/>
			<ul id="crop1">
				
			</ul>
		</div>
		<!--end-->
		<!--end-->
		<div class="photo_bc">
			<span class="hr_top"></span>
			<div class="photo_album">
				<div class="layui-row layui-col-space10 album" id="list">
					
				</div>
			</div>
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
 	   						<li><i class="layui-icon layui-icon-right" style="font-size: 15px; color: #fff;"></i>  Home</li>
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
	<script type="text/javascript" src="layui/layui.js" charset="utf-8"></script>
	<script>
		var price=100
// 		$(document).on('change','.num',function() {
// 			console.log($(this).val());
// 			});
		layui.use('layer', function() { //独立版的layer无需执行这一句
			var $ = layui.jquery,
				layer = layui.layer; //独立版的layer无需执行这一句

			//触发事件
			var active = {
				offset: function(othis) {
					var type = othis.data('type'),
						text = othis.text(),
						tt = othis.data('url');

					layer.open({
						type: 1,
						offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
							,
						title: false,
						id: 'layerDemo' + type //防止重复弹出
							,
						content: '<div style="padding: 0px 0px;width:400px;">' + tt + '</div>',
						//						btn: '关闭全部',
						btnAlign: 'c' //按钮居中
							,
						shade: [0.8, '#393D49'] //显示遮罩
							,
						area: '400px',
						yes: function() {
							layer.closeAll();
						}
					});
				},
				offset1: function(othis) {
					var type = othis.data('type');
					layer.open({
						type: 1,
						offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
							,
						title: false,
						id: 'layerDemo1' + type //防止重复弹出
							,
						content: '<div class="area_box">\
							<div class="layui-row layui-col-space5">\
								<div class="layui-col-xs2">\
								<input type=radio name=checkk id=act1 checked><label class="money_trans" for="act1"><span>100田园币</span><span>1￥</span></label>\
								</div>\
								<div class="layui-col-xs2">\
								<input type=radio name=checkk id=act2><label class="money_trans" for="act2"><span>200田园币</span><span>2￥</span></label>\
								</div>\
								<div class="layui-col-xs2">\
								<input type=radio name=checkk id=act3><label class="money_trans" for="act3"><span>300田园币</span><span>3￥</span></label>\
								</div>\<div class="layui-col-xs2">\
								<input type=radio name=checkk id=act4><label class="money_trans" for="act4"><span>400田园币</span><span>4￥</span></label>\
								</div>\<div class="layui-col-xs2">\
								<input type=radio name=checkk id=act5><label class="money_trans" for="act5"><span>500田园币</span><span>5￥</span></label>\
								</div>\<div class="layui-col-xs2">\
								<input type=radio name=checkk id=act6><label class="money_trans" for="act6"><span>1000田园币</span><span>10￥</span></label>\
								</div>\
							</div>\
							</div>\
							<div class="area_foot">\
							<div id=clc >\
							<img id=im1 class=in src=img/add_img/zfb.jpg\> \
							<img id=im2 class=in src=img/add_img/wec.jpg\> \
							<img class=box_right src=img/add_img/mai.jpg\> \
							</div>\
							</div>',
						//						btn: '关闭全部',
						btnAlign: 'c' //按钮居中
							,
						shade: [0.8, '#393D49'] //显示遮罩
							,
						area: ['600px', '400px'],
						yes: function() {
							layer.closeAll();
						}
					});
				},
				offset2: function(othis) {
					var type = othis.data('type'),
						text = othis.text(),
						pid=othis.data('pid'),
						num=othis.data('num'),
						tt = $(this).attr('src');
						price=othis.data('price'),
					layer.open({
						type: 1,
						offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
							,
						title: false,
						id: price //防止重复弹出
							,
						content: '<form class="layui-form" action="Planting"><div style="padding: 0px 0px;width:400px;text-align:center;margin:0 100px">' + '<span class=seed_plant><img src=' + tt + '>' + '</span>\
						<br><label>请选择种植的单位：<input type=hidden name=pid value='+pid+'><div class="layui-form-item"><div class="layui-input-inline"><input style="margin-left:160px;"  onchange="ccc()" id="aaa" name="amount" type=number  min=1 max='+num+'></div></div><button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button></label><br><div class=mes_box><p>共计<label id=bbb></label>金币</p></div></div></form>',
						//						btn: '关闭全部',
						btnAlign: 'c' //按钮居中
							,
						shade: [0.8, '#393D49'] //显示遮罩
							,
						area: ['600px', '400px'],
						yes: function() {
							layer.closeAll();
						}
					});
				},
				offset3: function(othis) {
					var type = othis.data('type'),
						text = othis.text(),
						cid=othis.data('cid'),
						tt = $(this).attr('src');
					layer.open({
						type: 2,
						offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
							,
						title: false,
						id: 'layerDemo3' + type //防止重复弹出
							,
						content: 'express.jsp',
						//						btn: '关闭全部',
						btnAlign: 'c' //按钮居中
							,
						shade: [0.8, '#393D49'] //显示遮罩
							,
						area: ['690px', '400px'],
						yes: function() {
							layer.closeAll();
						},
						success: function(layero, index){
							var body = layer.getChildFrame('body',index);//建立父子联系
							body.find('input[name="id"][type="text"],[type="hidden"]').val(cid)
						}
					});
				}


			};
			$('.clic').on('click', function() {
				var othis = $(this),
					method = othis.data('method');
				active[method] ? active[method].call(this, othis) : '';
			});
			
		});
		function ccc()
		{
			var amount=$('#aaa').val();
			$('#bbb').html(amount*price);
		}
	</script>
	
</html>