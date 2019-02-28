<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>城市方寸田-后台管理</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
  <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
  <script type="text/javascript">
  $(function addPlant(){
	  
  })
  </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">城市方寸田-后台管理</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">种子管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath}/admin/showPlant.jsp" target="viewDiv">查看种子</a></dd>
            <dd><a id="add" style="cursor:pointer">新增种子</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">查看种植请求</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath}/admin/showOrder.jsp?flag=0" target="viewDiv">查看未处理订单</a></dd>
            <dd><a href="${pageContext.request.contextPath}/admin/showOrder.jsp?flag=1" target="viewDiv">查看已处理订单</a></dd>
            <dd><a href="${pageContext.request.contextPath}/admin/showOrder.jsp?flag=-1" target="viewDiv">查看所有订单</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">植物空间管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath}/admin/showOperation.jsp" target="viewDiv">查看用户操作</a></dd>
            <dd><a id="addDiary" style="cursor:pointer">上传种植日记</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/admin/showUser.jsp" target="viewDiv">用户管理</a></li>
      	<li class="layui-nav-item"><a id="addCrop" style="cursor:pointer">上传成熟作物</a></li>
      	<li class="layui-nav-item"><a href="${pageContext.request.contextPath}/admin/showDelivery.jsp" target="viewDiv">查看配送请求</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <iframe name="viewDiv" id="viewDiv" style="width:100%;height:99%;" src="${pageContext.request.contextPath}/admin/showPlant.jsp">
    </iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
layui.use('layer', function(){
    var $ = layui.jquery
        ,layer = layui.layer //弹层

    
    $(document).on('click','#add',function(){
        //alert("这里写自己的功能...");
        layer.open({ //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
            type: 2,
            title:"新增种子",
            area: ['470px', '600px'],//类型：String/Array，默认：'auto'  只有在宽高都定义的时候才不会自适应
            fix: false, //不固定
            maxmin: true,//开启最大化最小化按钮
            shadeClose: true,//点击阴影处可关闭
            shade:0.4,//背景灰度
            skin: 'layui-layer-rim', //加上边框
            content: '${pageContext.request.contextPath}/admin/addPlant.jsp',
            // resize:false
        });
    });
    $(document).on('click','#addDiary',function(){
        //alert("这里写自己的功能...");
        layer.open({ //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
            type: 2,
            title:"上传日记",
            area: ['470px', '600px'],//类型：String/Array，默认：'auto'  只有在宽高都定义的时候才不会自适应
            fix: false, //不固定
            maxmin: true,//开启最大化最小化按钮
            shadeClose: true,//点击阴影处可关闭
            shade:0.4,//背景灰度
            skin: 'layui-layer-rim', //加上边框
            content: '${pageContext.request.contextPath}/admin/addNewDiary.jsp',
            // resize:false
        });
    });
    $(document).on('click','#addCrop',function(){
        //alert("这里写自己的功能...");
        layer.open({ //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
            type: 2,
            title:"上传成熟作物",
            area: ['470px', '600px'],//类型：String/Array，默认：'auto'  只有在宽高都定义的时候才不会自适应
            fix: false, //不固定
            maxmin: true,//开启最大化最小化按钮
            shadeClose: true,//点击阴影处可关闭
            shade:0.4,//背景灰度
            skin: 'layui-layer-rim', //加上边框
            content: '${pageContext.request.contextPath}/admin/addCrop.jsp',
            // resize:false
        });
    });


});
</script>
</body>
</html>