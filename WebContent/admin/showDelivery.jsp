<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"  media="all">
</head>
<body>
<table id="demo" lay-filter="demo"></table>
<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="do">处理</a>
</script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use('table', function(){
	  var table = layui.table;
	  
	  //第一个实例
	  table.render({
	    elem: '#demo'
	    ,height: 600
	    ,limit:5
	    ,limits:[5,10,15,20,25]
	    ,url: '${pageContext.request.contextPath}/GetAllDelivery' //数据接口
	    ,page: true //开启分页
	    ,cols: [[ //表头
	      {field: 'id', title: 'ID', width:80, sort: true}
	      ,{field: 'name', title: '收货人', width:80}
	      ,{field: 'tel', title: '联系方式', width:180} 
	      ,{field: 'addr', title: '送货地址', width:280}
	      ,{field: 'downdate', title: '下单时间',width:180, templet:function(d){
	    	  return "<div>"+(d.downdate.year+1900)+"年"+(d.downdate.month+1)+"月"+d.downdate.date+"日</div>";
	      }}
	      ,{field: 'crop', title: '货物信息',width:180, templet:function(d){
	    	  return "<div>"+(d.crop.plant.name)+":"+(d.crop.weight)+"kg</div>";
	      }}
	      ,{width:180, align:'center', toolbar: '#barDemo'}
	    ]]
	   
	  });
	  //监听工具条
	  table.on('tool(demo)', function(obj){
	    var data = obj.data;
	    var index = layer.getFrameIndex(window.name); //获取窗口索引
	    if(obj.event === 'do'){
	    	var $=layui.$;
	        $.ajax({
                url: '${pageContext.request.contextPath}/HandleDelivery',
                type: 'get',
                async:false,
                data: {
                	id: data.id
                } ,
                success: function(result){
                    if(result==1){
                        layer.msg('操作成功....', {icon: 6});
                        setTimeout(function(){
                            layer.close(index);
                            layui.table.reload('demo');
                        }, 1000);
                    }else{
                        layer.msg('操作失败', {icon: 5});
                    }
                } ,
            });
	    }
	  });
	
	});
</script>

</body>
</html>