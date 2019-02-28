$(function(){
	$("#searchname").click(function(){
		var jsonobj;
		$(function () {
			$.ajax({
				type:"get",
				url:"QueryPlant?flag=1&name="+$("#name").val(),
				async: false,
				success:function(data) {
					jsonobj = eval("(" + data + ")");
				}
			})

		})
		layui.use(['laypage', 'layer'], function() {
		var laypage = layui.laypage,
			layer = layui.layer;
		//将一段数组分页展示
		//调用分页
		laypage.render({
			elem: 'demo20',
			count: jsonobj.length,
			limit:3,
			jump: function(obj) {
				//模拟渲染
				document.getElementById('list').innerHTML = function() {
					var arr = [],
						thisData = jsonobj.concat().splice(obj.curr * obj.limit - obj.limit, obj.limit);
					layui.each(thisData, function(index, item) {
						//arr.push('<li>' + item.id+item.name+ '</li>');
						arr.push(
								"<div class='layui-col-xs4'>"+
								"<img style='width:200px;height:200px;' src='/img/other_img/"+item.img+"' /><br /><br />"+
								"<p>"+item.name+"种子"+"<label class='lable'>编号<strong>"+item.id+"</strong></label></p>"+
								"<p class='zhushi' style='height:150px;'>"+item.des+"</p>"+
								"<p> 单位面积售价：<label class='lable'>"+item.salePrice+"元</label></p>"+
								"<p>"+
									"<form action='BuyPlant' class='layui-form' method='post'>"+
										"<input type='hidden' value='"+item.id+"' name='id'>"+
										"<div class='layui-form-item' style='margin-left: -25px;'>"+
											"<label class='layui-form-label'>购买数量：</label>"+
											"<div class='layui-input-block' style='width: 40%;'>"+
										      "<input type='text' name='amount' lay-verify='required|number'  autocomplete='off' class='layui-input'>"+
											"</div>"+
										"</div>"+
										"<div class='layui-form-item'>"+
										    "<div class='layui-input-inline' style='margin-left: 50px;'>"+
										      "<button class='layui-btn' lay-submit='' lay-filter='demo1'>确认购买</button>"+
										    "</div>"+
										"</div>"+
									"</form>"+
								"</p>"+
								"<hr width='90%' />"+
							"</div>"
								);
					});
					return arr.join('');
				}();
			}
		});

	});
	})
	$("#searchprice").click(function(){
		var jsonobj;
		$(function () {
			$.ajax({
				type:"get",
				url:"QueryPlant?flag=2&begin="+$("#begin").val()+"&end="+$("#end").val(),
				async: false,
				success:function(data) {
					jsonobj = eval("(" + data + ")");
				}
			})
	
		})
		layui.use(['laypage', 'layer'], function() {
		var laypage = layui.laypage,
			layer = layui.layer;
		//将一段数组分页展示
		//调用分页
		laypage.render({
			elem: 'demo20',
			count: jsonobj.length,
			limit:3,
			jump: function(obj) {
				//模拟渲染
				document.getElementById('list').innerHTML = function() {
					var arr = [],
						thisData = jsonobj.concat().splice(obj.curr * obj.limit - obj.limit, obj.limit);
					layui.each(thisData, function(index, item) {
						//arr.push('<li>' + item.id+item.name+ '</li>');
						arr.push(
								"<div class='layui-col-xs4'>"+
								"<img style='width:200px;height:200px;' src='/img/other_img/"+item.img+"' /><br /><br />"+
								"<p>"+item.name+"种子"+"<label class='lable'>编号<strong>"+item.id+"</strong></label></p>"+
								"<p class='zhushi' style='height:150px;'>"+item.des+"</p>"+
								"<p> 单位面积售价：<label class='lable'>"+item.salePrice+"元</label></p>"+
								"<p>"+
									"<form action='BuyPlant' class='layui-form' method='post'>"+
										"<input type='hidden' value='"+item.id+"' name='id'>"+
										"<div class='layui-form-item' style='margin-left: -25px;'>"+
											"<label class='layui-form-label'>购买数量：</label>"+
											"<div class='layui-input-block' style='width: 40%;'>"+
										      "<input type='text' name='amount' lay-verify='required|number'  autocomplete='off' class='layui-input'>"+
											"</div>"+
										"</div>"+
										"<div class='layui-form-item'>"+
										    "<div class='layui-input-inline' style='margin-left: 50px;'>"+
										      "<button class='layui-btn' lay-submit='' lay-filter='demo1'>确认购买</button>"+
										    "</div>"+
										"</div>"+
									"</form>"+
								"</p>"+
								"<hr width='90%' />"+
							"</div>"
								);
					});
					return arr.join('');
				}();
			}
		});
	
	});
	})
})