<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<!-- <script type="text/javascript" src="js/zfb.js"></script> -->
	</head>

	<link rel="stylesheet" href="layui/css/layui.css" />
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/menu.css" />
	<link rel="stylesheet" href="css/foot.css" />
	<link rel="stylesheet" href="css/friend_lan.css" />
	<link rel="stylesheet" href="css/style.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/friend_lan.js"></script>
	<script type="text/javascript" src="js/pack.js"></script>
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
	<!-- 	<script type="text/javascript" src="js/czstore.js"></script> -->
	<body>
		<!--首页大轮播图-->
		<!-- 好友栏 -->
		<div class="box">
			<div class="box_head">
				<label>我的等级</label><span>&nbsp;121</span>
				<p><img src="img/add_img/ad.png" /></p>
			</div>
			<div class="box_content">
				<div class="tab">
					<input type="radio" name="check" id="active1" checked /><label class="init one" for="active1">所有好友</label>
					<div class="show">
						<ul>
							<li>
								<img src="img/other_img/team-2.jpg" />
								<label class="lv">lv147</label>
								<img class="del" src="img/add_img/del.png" />
								<p class="des">这是一段小这是一段小</p>

							</li>
							<li>
								<img src="img/other_img/team-2.jpg" />
								<label class="lv">lv147</label>
								<img class="del" src="img/add_img/del.png" />
								<p class="des">这是一段小这是一段小</p>

							</li>
							<li>
								<img src="img/other_img/team-2.jpg" />
								<label class="lv">lv147</label>
								<img class="del" src="img/add_img/del.png" />
								<p class="des">这是一段小这是一段小</p>

							</li>
							<li>
								<img src="img/other_img/team-2.jpg" />
								<label class="lv">lv147</label>
								<img class="del" src="img/add_img/del.png" />
								<p class="des">这是一段小这是一段小</p>

							</li>
						</ul>
					</div>
					<input type="radio" name="check" id="active2" /><label class="init two" for="active2">可操作好友</label>
					<div class="show">
						<ul>
							<li>
								<img src="img/other_img/team-1.jpg" />
								<label class="lv">lv147</label>
								<img class="del" src="img/add_img/del.png" />
								<p class="des">这是一段小这是一段小</p>

							</li>
							<li>
								<img src="img/other_img/team-1.jpg" />
								<label class="lv">lv147</label>
								<img class="del" src="img/add_img/del.png" />
								<p class="des">这是一段小这是一段小</p>

							</li>
							<li>
								<img src="img/other_img/team-1.jpg" />
								<label class="lv">lv147</label>
								<img class="del" src="img/add_img/del.png" />
								<p class="des">这是一段小这是一段小</p>

							</li>
							<li>
								<img src="img/other_img/team-1.jpg" />
								<label class="lv">lv147</label>
								<img class="del" src="img/add_img/del.png" />
								<p class="des">这是一段小这是一段小</p>

							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- end -->
		<div class="rehover">
			<!--头部引用-->
			<div class="index_menu">
				<nav id="test1">
					<a href="#" style="color: greenyellow;">HOME</a>
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
						<a href="#" style="color: greenyellow;">HOME</a>
						<a href="zone.jsp">ZONE</a>
						<a href="store.jsp">STORE</a>
						<a href="contact.jsp">CONTACT</a>
						<lable>|</label>
							<%
								if(session.getAttribute("user")==null){
							%>
								<span onclick="window.location.href='login.jsp';"><img src="img/add_img/wlog.png" />&nbsp;&nbsp;未登录</span>
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
			<!--end-->
			<div class="contain">
				<p class="banch">城市方寸田</p>
				<p class="banch_child">这是您自己的私人农场，在这里，您可以云种花，云种草，快来领取属于您的小农场吧！</p>
				<div class="join"><a href="#next">More...</a>
					<div class="back"></div>
				</div>
			</div>
		</div>
		<div class="layui-carousel" id="test10">
			<div carousel-item="">
				<div><img src="img/home_img/2.jpg"></div>
				<div><img src="img/home_img/gallery-img3.jpg"></div>
				<div><img src="img/home_img/img1.jpg"></div>
			</div>
		</div>
		<!--end-->
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
		<!--导航栏-->

		<!--<iframe id="topmenu"src="topmenu.html" width="100%"  name="topFrame" 
scrolling="No"  noresize="noresize" frameborder="0" id="topFrame"></iframe>-->
		<!--特色介绍-->
		<div class="mid">
			<div class="mid_con_top">
				<div class="mid_title">
					<strong id="next">Why Choose Us?</strong>
				</div>
				<div class="layui-row layui-col-space30">
					<div class="layui-col-xs4">
						<div class="col1">
							<span class="ico1 layui-icon layui-icon-fire"></span>
							<br /><br /><br /><br />
							<p>
								这里的蔬菜全部是绿色无污染，您选择的除虫除草全部是由手工处理！
								但是尊敬的客户也要注意了，对作物的维护都需要您发出指令的哦~
							</p>
						</div>
						<i></i>
					</div>
					<div class="layui-col-xs4">
						<div class="col2">
							<span class="ico2 layui-icon layui-icon-rate-half"></span>
							<br /><br /><br /><br />
							<p>
								您可以定期查看您所选的作物的生长日记，或者直接通过摄像头观看。
								生长日记由专人维护，有趣且真实，摄像头24小时全天候开放~
							</p>
						</div>
						<i></i>
					</div>
					<div class="layui-col-xs4">
						<div class="col3">
							<span class="ico3 layui-icon layui-icon-date"></span>
							<br /><br /><br /><br />
							<p>
								您选择的作物在您的关注和我们的悉心照顾下成熟后将由我们公司免费
								邮递到您指定的地方，可以当做有意义的礼物也可以自己品尝哦~
							</p>
						</div>
						<i></i>
					</div>
				</div>
			</div>
		</div>
		<!--------------------------------侧边栏------------------------>
		<!-- 		<div class="celan">
			<a href="login.html"><span class="layui-icon layui-icon-username" style="font-size: 30px;color: #fff;"></span>
				<span style="font-size: 12px;color: white;">账号</span></a>
			<div class="bac">
				<a href="zone.html"><span class="layui-icon layui-icon-home" style="font-size: 30px;color: #fff;"></span>
					<span class="zero">空间</span></a>
			</div>
			<span id="totop" class="layui-icon layui-icon-top" style="font-size: 40px;cursor:pointer;color: #fff;position: relative;top:260px;"></span>

		</div> -->
		<!---------------------------------害虫治理------------------------>
		<div class="mid_mid">
			<div class="mid_mid_title">
				<br /><br />
				<h2>害虫治理</h2>
				<br />
				<p>影响作物生长的虫子有很多，但是也有很多有益于植物生长的虫子，七星瓢虫就在其中，
					它可以帮助我们绿色无公害的处理那些烦人的害虫。
				</p>
			</div>
			<div class="layui-row layui-col-space30 pet">
				<div class="layui-col-xs4">
					<div class="mid_mid_pets1">
						<div class="pet_background">
						</div>
						<div class="pet_back">
							<br /><br />

							可以养一些害虫的天敌去除虫，而不必去打农药，保证作物的绿色环保！
						</div>
						<div class="pet_face">
						</div>
					</div>
				</div>
				<div class="layui-col-xs4">
					<div class="mid_mid_pets2">
						<div class="pet_background">
						</div>
						<div class="pet_back">
							<br /><br />
							七星瓢虫由专人培育，在害虫季节投放在农田里，保证作物的正常生长！
						</div>
						<div class="pet_face">
						</div>
					</div>
				</div>
				<div class="layui-col-xs4">
					<div class="mid_mid_pets3">
						<div class="pet_background">
						</div>
						<div class="pet_back">
							<br /><br />
							真正的绿色无公害，利用大自然的食物链来帮助作物的生长，真正的返璞归真~
						</div>
						<div class="pet_face">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="mid_bottom">
			<div class="mid_bottom_title">
				植物日记
			</div>
			<div class="layui-row layui-col-space10 pet">
				<div class="layui-col-xs3">
					<div class="diary1">
						<p class="p_title">Growing day</p>
						<p class="date">8.00 - 10.00 | JUN 09,2014</p>
						<span class="recover1"><i data-url="<img width=100% src=img/home_img/fe.jpg />" data-method="offset" data-type="auto"
							 class="layui-icon layui-icon-search clic" style="font-size: 30px;"></i></span>
						<img src="img/home_img/fe.jpg" />
					</div>
				</div>
				<div class="layui-col-xs3">
					<div class="diary2">
						<p class="p_title">Growing day</p>
						<p class="date">9.00 - 10.00 | JUN 09,2018</p>
						<span class="recover1"><i data-url="<img width=100% src=img/home_img/fe1.jpg />" data-method="offset" data-type="auto"
							 class="layui-icon layui-icon-search clic" style="font-size: 30px;"></i></span>
						<img src="img/home_img/fe1.jpg" />
					</div>
				</div>
				<div class="layui-col-xs3">
					<div class="diary3">
						<p class="p_title">Growing day</p>
						<p class="date">10.00 - 12.00 | JULY 09,2018</p>
						<span class="recover1"><i data-url="<img width=100% src=img/home_img/fe2.jpg />" data-method="offset" data-type="auto"
							 class="layui-icon layui-icon-search clic" style="font-size: 30px;"></i></span>
						<img src="img/home_img/fe2.jpg" />
					</div>
				</div>
				<div class="layui-col-xs3">
					<div class="diary4">
						<p class="p_title">Growing day</p>
						<p class="date">13.00 - 14.00 | MAR 01,2018</p>
						<span class="recover1"><i data-url="<img width=100% src=img/home_img/fe3.jpg />" data-method="offset" data-type="auto"
							 class="layui-icon layui-icon-search clic" style="font-size: 30px;"></i></span>
						<img src="img/home_img/fe3.jpg" />
					</div>
				</div>
			</div>
		</div>
		<div class="newsletter">
			<div class="cont">
				<p><span>订阅</span>我们的时事通讯</p>
				<p class="mes">订阅我们的时事通讯，您能够获得第一手资料哦，能够密切关注自己的作物！</p>
				<form action="#" method="get">
					<input name="Your Name" placeholder="Your Name" type="text" required="">
					<input name="Your Email" placeholder="Your Email" type="email" required="">
					<input type="submit" value="订阅">
				</form>
			</div>
		</div>
		<footer>
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
		</footer>
	</body>
	<script type="text/javascript" src="layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script>
		layui.use(['carousel', 'form'], function() {
			var carousel = layui.carousel,
				form = layui.form;
			carousel.render({
				elem: '#test10',
				width: '100%',
				height: '700px',
				interval: 2000 //时间间隔（ms）
					,
				arrow: 'none',
				autoplay: true,
				indicator: 'none',
				anim: 'fade'

			});
		});
	</script>
	<script>
		$(function() {
			var speed = 600;
			$("#totop").click(function() {
				$("html,body").animate({
					"scrollTop": 0
				}, speed);
			});
		});
	</script>

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
						<br><label>请选择种植的单位：<input type=hidden name=pid value='+pid+'><div class="layui-form-item"><div class="layui-input-inline"><input style="margin-left:160px;"  onchange="ccc()" id="aaa" name="amount" type=number  min=1 max='+num+'></div></div><button class="layui-btn" lay-submit="" lay-filter="demo1">提交</button></label><br><div class=mes_box><p>共计<label id=bbb></label>金币</p></div></div></form>',
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