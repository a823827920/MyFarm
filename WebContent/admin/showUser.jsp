<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"  media="all">
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
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use('table', function(){
	  var table = layui.table;
	  
	  //第一个实例
	  table.render({
	    elem: '#demo'
	    ,height: 630
	    ,limit:5
	    ,limits:[5,10,15,20,25]
	    ,url: '${pageContext.request.contextPath}/GetAllUser' //数据接口
	    ,page: true //开启分页
	    ,cols: [[ //表头
	      {field: 'id', title: 'ID', width:80, sort: true}
	      ,{field: 'name', title: '昵称', width:120}
	      ,{field: 'sex', title: '性别', width:80, sort: true}
	      ,{field: 'tel', title: '电话', width:150} 
	      ,{field: 'email', title: '电子邮箱', width: 177}
	      ,{field: 'money', title: '余额', width: 80, sort: true}
	      ,{field: 'img', title: '图片(点击查看大图)',width:160,style:'height:110px', templet:function(d){
	    	  return "<div class='layer-photos-demo' style='cursor:pointer;'><img src='/img/other_img/"+d.img+"'></div>";
	      }}
	      ,{field: 'des', title: '个性签名'}
	    ]]
	    ,done: function(res, curr, count) { //表格数据加载完后的事件
	        //调用示例
	        layer.photos({//点击图片弹出
	            photos: '.layer-photos-demo'
	            ,anim: 0 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
	        });
	        
	    }
	  });
	  //监听工具条
	  table.on('tool(demo)', function(obj){
	    var data = obj.data;
	    var index = layer.getFrameIndex(window.name); //获取窗口索引
	    if(obj.event === 'add'){
	    	var $=layui.$;
	        $.ajax({
                url: '${pageContext.request.contextPath}/UpDownShelf',
                type: 'get',
                async:false,
                data: {
                	id: data.id,
                	flag:1
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
	    } else if(obj.event === 'del'){
	      layer.confirm('真要下架吗？', function(index){
	        //obj.del();
	        var $=layui.$;
	        $.ajax({
                url: '${pageContext.request.contextPath}/UpDownShelf',
                type: 'get',
                async:false,
                data: {
                	id: data.id,
                	flag:0,
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
            return false;
        });
	      layer.close(index);
	    } else if(obj.event === 'edit'){
	      //layer.alert('编辑行：<br>'+ JSON.stringify(data))
	    	layer.open({
                type: 2,
                title: '' +
                '<li id="icon" class="layui-icon layui-icon-release layui-anim layui-anim-scaleSpring" ' +
                'style="font-size: 30px; color: #009688;" data-anim="layui-anim-scaleSpring"></li> 编辑 ',
                shadeClose: true,
                shade: false,
                maxmin: true, //开启最大化最小化按钮
                area: ['470px', '600px'],//area: [window.screen.width / 2 + 'px', window.screen.height / 2 + 'px'], //宽高
                content: "${pageContext.request.contextPath}/admin/plantEdit.jsp",
                success: function(layero, index){
                    var body = layer.getChildFrame('body',index);//建立父子联系
                    // 获取子页面的iframe
                    var iframe = window['layui-layer-iframe' + index];
                    // console.log(arr); //得到iframe页的body内容
                    // console.log(body.find('input'));
                    var inputList = body.find('input');
                    var json=JSON.parse(JSON.stringify(data));
                    for(let d in json){
                        body.find('input[name="'+d+'"][type="text"],[type="hidden"]').val(json[d])
                    }
                    body.find('img').attr('src','/img/other_img/'+json['img'])
                }
            });
	    }
	  });
	
	});
</script>

</body>
</html>