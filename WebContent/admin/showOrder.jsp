<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"  media="all">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/getParam.js"></script>
 <script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
<style type="text/css">
        .layui-table-cell{
        height: 100%;
 }
</style>

</head>
<body>
<table id="demo" lay-filter="demo"></table>

<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/html" id="barDemo">
{{#  if(d.flag ==1){ }}
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="dealed">已处理</a>
{{#  } else { }}
<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="toDeal">处理</a>
{{#  } }}
</script>
<script type="text/html" id="flagTpl">
  {{#  if(d.flag ==1){ }}
    <span>已完成</span>
  {{#  } else { }}
    <span>未完成</span>
  {{#  } }}
</script>
<script type="text/html" id="FieldTpl">
  {{#  if(d.field_id <=0){ }}
    <span>未分配</span>
  {{#  }else{ }}
	<span>{{d.field_id}}</span>
  {{#  } }}
</script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
var obj=getParam();
var flag='-1';
flag=obj['flag'];
layui.use('table', function(){
	  var table = layui.table;
	  
	  //第一个实例
	  table.render({
	    elem: '#demo'
	    ,height: 600
	    ,limit:4
	    ,limits:[2,4,6,8,10]
	    ,url: '${pageContext.request.contextPath}/GetAllRoomItems?flag='+flag //数据接口
	    ,page: true //开启分页
	    ,cols: [[ //表头
	      {field: 'id', title: 'ID', width:80, sort: true}
	      ,{field: 'plant_id', title: '植物ID', width:130,sort: true,templet:function(d){
	    	  return d.plant.id;
	      }}
	      ,{field: 'plant_name', title: '植物名称', width:130,templet:function(d){
	    	  return d.plant.name;
	      }}
	      ,{field: 'field_id', title: '土地编码', width:130, templet:'#FieldTpl'}
	      ,{field: 'user_id', title: '用户ID', width:80,sort:true} 
	      ,{field: 'date', title: '最新操作时间', width: 128,templet:function(d){
	    	  day=d.date.date.toString();
	    	  month=(d.date.month+1).toString();
	    	  year=(d.date.year+1900).toString();
	    	  return year+'-'+month+'-'+day
	      }}
	      ,{field: 'start', title: '种植时间', width: 128,templet:function(d){
	    	  day=d.date.date.toString();
	    	  month=(d.date.month+1).toString();
	    	  year=(d.date.year+1900).toString();
	    	  return year+'-'+month+'-'+day
	      }}
	      ,{field: 'flag', title: '状态', sort:true,width: 135,templet:'#flagTpl'}
	      ,{width:180, align:'center', toolbar: '#barDemo'}
	    ]]
	    
	  });
	  //监听工具条
	  table.on('tool(demo)', function(obj){
	    var data = obj.data;
	    var index = layer.getFrameIndex(window.name); //获取窗口索引
	    if(obj.event === 'toDeal'){
	    	var $=layui.$;
	        $.ajax({
                url: '${pageContext.request.contextPath}/UpDownRIShelf',
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
	    } else if(obj.event === 'dealed'){
	    	 layer.msg('该订单已处理', {icon: 6});
	    } 
	  });
	
	});
</script>

</body>
</html>